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

  Logger：
  Logger对象是用来取代System.out或者System.err的日志输出器，负责日志信息的输出；其中，log4j日志框架提供了info、error、debug等API供Developer使用；

  与commons-logging相同，log4j也有日志等级的概念；每一个logger对象都会分配一个等级，未被分配等级的logger则继承根logger的级别，进行日志的输出；每个日志对象方法的请求也有一个等级，如果方法请求的等于大于当前logger对象的等级，则该请求会被处理输出，否则该请求被忽略；

  log4j在Level类中定义了7个等级，关系如下：
      Level.ALL < Level.DEBUG < Level.INFO < Level.WARN < Level.ERROR < Level.FATAL < Level.OFF

  每个等级，具体含义如下：
      ALL:打开所有日志；
      DEBUG：适用于代码调试期间；
      INFO：适用于代码运行期间；
      WARN：适用于代码会有潜在错误事件；
      ERROR：适用于代码存在错误事件；
      FATAL：适用于严重错误事件；
      OFF：关闭所有日志；

Appender：
    日志输出目的地，负责把格式好的日志信息输出到指定地方，可以是控制台、磁盘文件等；
  每个日志对象，都有一个对应的appender，每个appender代表着一个日志输出目的地；

  其中，log4j有以下几种appender可供选择：
      ConsoleAppender：控制台；
      FileAppender：磁盘文件；
      DailyRollingFileAppender：每天产生一个日志磁盘文件；
      RollingFileAppender：日志磁盘文件大小达到指定尺寸时产生一个新的文件；

Layout：
        日志格式化器，负责发布不同风格的日志信息；
        每个appender和一个Layout相对应，appende负责把日志信息输出到指定的地点，而Layout则负责把日志信息按照格式化的要求展示出来；

  其中，log4j有以下几种Layout可供选择：
      HTMLLayout：以html表格形式布局展示；
      PatternLayout：自定义指定格式展示；
      SimpleLayout：包含日志信息的级别和信息字符串；
      TTCCLayout：包含日志产生的时间、线程、类别等等信息

作者：贾博岩
链接：https://www.jianshu.com/p/f2d4a54f9c41
来源：简书
简书著作权归作者所有，任何形式的转载都请联系作者获得授权并注明出处。

 */