/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache license, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the license for the specific language governing permissions and
 * limitations under the license.
 */
package org.apache.logging.log4j.layout.json.template.resolver;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.apache.logging.log4j.layout.json.template.util.JsonWriter;
import org.apache.logging.log4j.util.BiConsumer;

final class PatternResolver implements EventResolver {

    private final BiConsumer<StringBuilder, LogEvent> emitter;

    PatternResolver(
            final EventResolverContext context,
            final String key) {
        final PatternLayout patternLayout = PatternLayout
                .newBuilder()
                .setConfiguration(context.getConfiguration())
                .setCharset(context.getCharset())
                .setPattern(key)
                .build();
        this.emitter = (final StringBuilder stringBuilder, final LogEvent logEvent) ->
                patternLayout.serialize(logEvent, stringBuilder);
    }

    static String getName() {
        return "pattern";
    }

    @Override
    public void resolve(final LogEvent logEvent, final JsonWriter jsonWriter) {
        jsonWriter.writeString(emitter, logEvent);
    }

}
