// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto/person.proto

package dto;

public interface PersonOrBuilder extends
    // @@protoc_insertion_point(interface_extends:dto.Person)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional string name = 1;</code>
   * @return Whether the name field is set.
   */
  boolean hasName();
  /**
   * <code>optional string name = 1;</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <code>optional string name = 1;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>optional string email = 3;</code>
   * @return Whether the email field is set.
   */
  boolean hasEmail();
  /**
   * <code>optional string email = 3;</code>
   * @return The email.
   */
  java.lang.String getEmail();
  /**
   * <code>optional string email = 3;</code>
   * @return The bytes for email.
   */
  com.google.protobuf.ByteString
      getEmailBytes();
}
