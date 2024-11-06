package com.example.reservation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {

   private int errorCode;
   private String errorMessage;
   private String devErrorMessage;
   private Long timestamp;

   public int getErrorCode() {
      return errorCode;
   }

   public void setErrorCode(int errorCode) {
      this.errorCode = errorCode;
   }

   public String getErrorMessage() {
      return errorMessage;
   }

   public void setErrorMessage(String errorMessage) {
      this.errorMessage = errorMessage;
   }

   public String getDevErrorMessage() {
      return devErrorMessage;
   }

   public void setDevErrorMessage(String devErrorMessage) {
      this.devErrorMessage = devErrorMessage;
   }

   public Long getTimestamp() {
      return timestamp;
   }

   public void setTimestamp(Long timestamp) {
      this.timestamp = timestamp;
   }
}
