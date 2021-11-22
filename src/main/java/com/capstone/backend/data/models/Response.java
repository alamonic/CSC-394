package com.capstone.backend.data.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="user_responses")
public class Response {
    @Id @Getter @GeneratedValue
    private Integer response_id;
    @Getter @Setter
    private Long time_to_complete; // time measured in milliseconds, use System.currentTimeMillis()
    @Getter @Setter
    private String comments; // user comments
    @Getter @Setter
    private String question1 = "How difficult was the work you completed?";
    @Getter @Setter
    private Integer response1; // stored as int since the question will have a 1-5 scale
    @Getter @Setter
    private String question2;
    @Getter @Setter
    private Integer response2; // stored as int since the question will have a 1-5 scale
    @Getter @Setter
    private String question3;
    @Getter @Setter
    private Integer response3; // stored as int since the question will have a 1-5 scale
    @Getter @Setter
    private String question4;
    @Getter @Setter
    private Integer response4; // stored as int since the question will have a 1-5 scale
    @Getter @Setter
    private String question5;
    @Getter @Setter
    private Integer response5; // stored as int since the question will have a 1-5 scale
    @Getter @Setter @ManyToOne
    private User userId;

    public Response() {
    }

    public Response(String comments, int response1, int response2, int response3, int response4, int response5, User user_id) {
        this.time_to_complete = 0L;
        this.comments = comments;
        this.response1 = response1;
        this.response2 = response2;
        this.response3 = response3;
        this.response4 = response4;
        this.response5 = response5;
        this.userId = user_id;
    }

    public Response(String comments, String question1, int response1, String question2, int response2, String question3, int response3, String question4, int response4, String question5, int response5, User user_id) {
        this.time_to_complete = 0L;
        this.comments = comments;
        this.question1 = question1;
        this.response1 = response1;
        this.question2 = question2;
        this.response2 = response2;
        this.question3 = question3;
        this.response3 = response3;
        this.question4 = question4;
        this.response4 = response4;
        this.question5 = question5;
        this.response5 = response5;
        this.userId = user_id;
    }

    public void SetCurrentDuration(long L)
    {
        this.time_to_complete = L;
    }

    @Override
    public String toString() {
        return "Response{" +
                "response_id=" + response_id +
                ", time_to_complete=" + time_to_complete +
                ", comments='" + comments + '\'' +
                ", question1='" + question1 + '\'' +
                ", response1=" + response1 +
                ", question2='" + question2 + '\'' +
                ", response2=" + response2 +
                ", question3='" + question3 + '\'' +
                ", response3=" + response3 +
                ", question4='" + question4 + '\'' +
                ", response4=" + response4 +
                ", question5='" + question5 + '\'' +
                ", response5=" + response5 +
                ", user_id=" + userId +
                '}';
    }

    public String toJSONString() {

        return "{" +
                "  " + '"' + "response_id" + '"' + " : " + response_id +
                ", " + '"' + "time_to_complete" + '"' + " : " + time_to_complete +
                ", " + '"' + "comments" + '"' + " : " + '"' + comments + '"' +
                ", " + '"' + "question1" + '"' + " : " + '"' + question1 + '"' +
                ", " + '"' + "response1" + '"' + " : "       + response1 +
                ", " + '"' + "question2" + '"' + " : " + '"' + question2 + '"' +
                ", " + '"' + "response2" + '"' + " : "       + response2 +
                ", " + '"' + "question3" + '"' + " : " + '"' + question3 + '"' +
                ", " + '"' + "response3" + '"' + " : "       + response3 +
                ", " + '"' + "question4" + '"' + " : " + '"' + question4 + '"' +
                ", " + '"' + "response4" + '"' + " : "       + response4 +
                ", " + '"' + "question5" + '"' + " : " + '"' + question5 + '"' +
                ", " + '"' + "response5" + '"' + " : "       + response5 +
                ", " + '"' + "user_id" + '"' + " : " + userId +
                '}';

    }
}
