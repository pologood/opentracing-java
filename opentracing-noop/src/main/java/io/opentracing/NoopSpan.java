/**
 * Copyright 2016-2017 The OpenTracing Authors
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
package io.opentracing;

import java.util.Map;

public interface NoopSpan extends Span {
    static final NoopSpan INSTANCE = new NoopSpanImpl();
}

final class NoopSpanImpl implements NoopSpan {


    @Override
    public SpanContext context() { return NoopSpanContextImpl.INSTANCE; }

    @Override
    public void finish() {}

    @Override
    public void finish(long finishMicros) {}

    @Override
    public Span setTag(String key, String value) { return this; }

    @Override
    public Span setTag(String key, boolean value) { return this; }

    @Override
    public Span setTag(String key, Number value) { return this; }

    @Override
    public Span log(Map<String, ?> fields) { return this; }

    @Override
    public Span log(long timestampMicroseconds, Map<String, ?> fields) { return this; }

    @Override
    public Span log(String event) { return this; }

    @Override
    public Span log(long timestampMicroseconds, String event) { return this; }

    @Override
    public Span log(String eventName, Object payload) { return this; }

    @Override
    public Span log(long timestampMicroseconds, String eventName, Object payload) { return this; }

    @Override
    public Span setBaggageItem(String key, String value) { return this; }

    @Override
    public String getBaggageItem(String key) { return null; }

    @Override
    public Span setOperationName(String operationName) { return this; }

    @Override
    public String toString() { return NoopSpan.class.getSimpleName(); }

}

