/*
 * Copyright (C) 2023 Thomas Akehurst
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wiremock.grpc.client;

import com.example.grpc.GreetingServiceGrpc;
import io.grpc.Channel;

public class GreetingsClient {

  private final GreetingServiceGrpc.GreetingServiceBlockingStub stub;

  public GreetingsClient(Channel channel) {
    stub = GreetingServiceGrpc.newBlockingStub(channel);
  }

  public String greet(String name) {
    return stub.greeting(com.example.grpc.HelloRequest.newBuilder().setName(name).build())
        .getGreeting();
  }
}