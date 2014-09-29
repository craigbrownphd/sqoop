/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.sqoop.handler;

import org.apache.log4j.Logger;
import org.apache.sqoop.audit.AuditLoggerManager;
import org.apache.sqoop.driver.Driver;
import org.apache.sqoop.json.DriverConfigBean;
import org.apache.sqoop.json.JsonBean;
import org.apache.sqoop.server.RequestContext;
import org.apache.sqoop.server.RequestHandler;

/**
 * Driver Config request handler is supporting following resources:
 *
 */
public class DriverConfigRequestHandler  implements RequestHandler {

  private static final Logger LOG =
      Logger.getLogger(DriverConfigRequestHandler.class);

  public DriverConfigRequestHandler() {
    LOG.info("DriverConfigRequestHandler initialized");
  }

  @Override
  public JsonBean handleEvent(RequestContext ctx) {
    AuditLoggerManager.getInstance()
        .logAuditEvent(ctx.getUserName(), ctx.getRequest().getRemoteAddr(),
        "get", "framework", "");

    return new DriverConfigBean(Driver.getInstance().getDriverConfig(),
      Driver.getInstance().getBundle(ctx.getAcceptLanguageHeader()));
  }
}