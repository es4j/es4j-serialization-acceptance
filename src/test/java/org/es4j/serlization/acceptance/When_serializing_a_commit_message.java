package org.es4j.serlization.acceptance;

import java.util.Map.Entry;
import java.util.UUID;
import org.es4j.eventstore.api.Commit;
import org.es4j.serialization.api.ISerialize;
import org.es4j.serialization.api.SerializationExtensions;
import org.es4j.util.GenericType;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;


public class When_serializing_a_commit_message extends Using_serialization {
    
    protected static final ISerialize serializer = new SerializationFactory().build();
    
    static final Commit message = ExtensionMethods.buildCommit(UUID.randomUUID());
    
    static byte[] serialized;
    static Commit deserialized;
    
    @Test
    public void should_deserialize_a_commit_which_contains_the_same_StreamId_as_the_serialized_commit() {
        
        // Given
         ISerialize serializer = new SerializationFactory().build();
        serialized = SerializationExtensions.serialize(serializer, message);
        
        // When
        deserialized = SerializationExtensions.deserialize(serializer, new GenericType<Commit>(){}, serialized);
        
        // Then It should_deserialize_a_commit_which_contains_the_same_StreamId_as_the_serialized_commit = () =>
        assertThat(deserialized.getStreamId(), is(message.getStreamId()));
        
        // Then It should_deserialize_a_commit_which_contains_the_same_CommitId_as_the_serialized_commit = () =>
        assertThat(deserialized.getCommitId(), is(message.getCommitId()));
        
        // Then It should_deserialize_a_commit_which_contains_the_same_StreamRevision_as_the_serialized_commit = () =>
        assertThat(deserialized.getStreamRevision(), is(message.getStreamRevision()));       
        

        // Then It should_deserialize_a_commit_which_contains_the_same_CommitSequence_as_the_serialized_commit = () =>
        assertThat(deserialized.getCommitSequence(), is(message.getCommitSequence()));

        // Then It should_deserialize_a_commit_which_contains_the_same_number_of_headers_as_the_serialized_commit = () =>
        assertThat(deserialized.getHeaders().size(), is(message.getHeaders().size()));

        // Than It should_deserialize_a_commit_which_contains_the_same_headers_as_the_serialized_commit = () =>
        {
            for (Entry<String,Object> entry : deserialized.getHeaders().entrySet()) {
                assertThat(entry.getValue(), is(message.getHeaders().get(entry.getKey())));
            }

            assertThat(deserialized.getHeaders().values(), is(message.getHeaders().values()));
        };

        // Then It should_deserialize_a_commit_which_contains_the_same_number_of_events_as_the_serialized_commit = () =>
        assertThat(deserialized.getEvents().size(), is(message.getEvents().size()));
    }
}


/*
[Subject("Serialization")]
public class when_serializing_a_commit_message : using_serialization
{
    static readonly Commit Message = Guid.NewGuid().BuildCommit();
    static byte[] serialized;
    static Commit deserialized;

    Establish context = () =>
            serialized = Serializer.Serialize(Message);

    Because of = () =>
            deserialized = Serializer.Deserialize<Commit>(serialized);

    It should_deserialize_a_commit_which_contains_the_same_StreamId_as_the_serialized_commit = () =>
            deserialized.StreamId.ShouldEqual(Message.StreamId);

    It should_deserialize_a_commit_which_contains_the_same_CommitId_as_the_serialized_commit = () =>
            deserialized.CommitId.ShouldEqual(Message.CommitId);

    It should_deserialize_a_commit_which_contains_the_same_StreamRevision_as_the_serialized_commit = () =>
            deserialized.StreamRevision.ShouldEqual(Message.StreamRevision);

    It should_deserialize_a_commit_which_contains_the_same_CommitSequence_as_the_serialized_commit = () =>
            deserialized.CommitSequence.ShouldEqual(Message.CommitSequence);

    It should_deserialize_a_commit_which_contains_the_same_number_of_headers_as_the_serialized_commit = () =>
            deserialized.Headers.Count.ShouldEqual(Message.Headers.Count);

    It should_deserialize_a_commit_which_contains_the_same_headers_as_the_serialized_commit = () =>
    {
            foreach (var header in deserialized.Headers)
                    header.Value.ShouldEqual(Message.Headers[header.Key]);

            deserialized.Headers.Values.SequenceEqual(Message.Headers.Values);
    };

    It should_deserialize_a_commit_which_contains_the_same_number_of_events_as_the_serialized_commit = () =>
            deserialized.Events.Count.ShouldEqual(Message.Events.Count);
}
*/