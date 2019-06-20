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
package org.apache.logging.log4j.core.config.plugins;

import org.apache.logging.log4j.core.config.plugins.visitors.PluginValueVisitor;
import org.apache.logging.log4j.plugins.PluginVisitorStrategy;


import java.lang.annotation.*;

/**
 * Identifies a parameter as a value. These correspond with property values generally, but are meant as values to be
 * used as a placeholder value somewhere.
 *
 * @see org.apache.logging.log4j.core.config.PropertiesPlugin
 * @deprecated Exists for compatibility with Log4j 2 2.x plugins. Not used for Log4j 2 3.x plugins.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.FIELD})
@PluginVisitorStrategy(PluginValueVisitor.class)
public @interface PluginValue {

    String value();
}