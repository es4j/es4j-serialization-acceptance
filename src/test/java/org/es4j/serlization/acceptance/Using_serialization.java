package org.es4j.serlization.acceptance;

import org.es4j.serialization.api.ISerialize;


public abstract class Using_serialization {
    protected static final ISerialize Serializer = new SerializationFactory().build();
}
