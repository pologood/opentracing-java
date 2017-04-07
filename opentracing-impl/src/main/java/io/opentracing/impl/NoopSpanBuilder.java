/**
 * Copyright 2016 The OpenTracing Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package io.opentracing.impl;

import io.opentracing.NoopSpanContext;
import io.opentracing.ActiveSpanHolder;
import io.opentracing.ThreadLocalActiveSpanHolder;

final class NoopSpanBuilder extends AbstractSpanBuilder implements io.opentracing.NoopSpanBuilder, NoopSpanContext {

    static final NoopSpanBuilder INSTANCE = new NoopSpanBuilder("noop", new ThreadLocalActiveSpanHolder());

    public NoopSpanBuilder(String operationName, ActiveSpanHolder activeSpanHolder) {
        super(operationName, activeSpanHolder);
    }

    @Override
    protected AbstractSpan createSpan() {
        return NoopSpan.INSTANCE;
    }

    @Override
    AbstractSpanBuilder withStateItem(String key, Object value) {
        return this;
    }

    @Override
    boolean isTraceState(String key, Object value) {
        return false;
    }
}
