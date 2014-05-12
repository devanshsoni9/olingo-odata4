/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.olingo.fit.proxy.v3;

import static org.junit.Assert.assertNotNull;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import org.apache.olingo.client.core.http.BasicAuthHttpClientFactory;
import org.apache.olingo.client.core.http.DefaultHttpClientFactory;
import org.apache.olingo.ext.proxy.EntityContainerFactory;
import org.apache.olingo.fit.proxy.v3.staticservice.microsoft.test.odata.services.astoriadefaultservice.
        DefaultContainer;

public class AuthEntityRetrieveTestITCase extends EntityRetrieveTestITCase {

  @BeforeClass
  public static void enableBasicAuth() {
    containerFactory.getConfiguration().
            setHttpClientFactory(new BasicAuthHttpClientFactory("odatajclient", "odatajclient"));
  }

  @AfterClass
  public static void disableBasicAuth() {
    containerFactory.getConfiguration().setHttpClientFactory(new DefaultHttpClientFactory());
  }

  @BeforeClass
  public static void setupContaner() {
    containerFactory = EntityContainerFactory.getV3(testAuthServiceRootURL);
    container = containerFactory.getEntityContainer(DefaultContainer.class);
    assertNotNull(container);
  }
}