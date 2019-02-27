/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.rocketmq.logging;

/*
 This package is a minimal logger on the basis of Apache Log4j without
 file configuration and pattern layout configuration. Main forked files are
 followed as below:
 1. LoggingEvent
 2. Logger 最上一层是 Logger 对象，该对象负责获取日志信息，并存储于一个分层的命名空间之中。
 3. Layout Layout 层提供了用于以各种风格格式化日志信息的对象，在发布日志信息之前，它为 appender 对象提供支持。
 4. Level Level 对象定义了日志信息的粒度和优先级。API 定义了七种级别：OFF、DEBUG、INFO、ERROR、WARN、FATAL、ALL。
 5. AsyncAppender Appender该对象位于分层架构中的较低一层，Appender 对象负责将日志信息发布到不同目的地，比如数据库、文件、控制台、Unix Syslog 等。
 6. FileAppender
 7. RollingFileAppender
 8. DailyRollingFileAppender
 9. ConsoleAppender

 For more information about Apache Log4j, please go to https://github.com/apache/log4j.
 */