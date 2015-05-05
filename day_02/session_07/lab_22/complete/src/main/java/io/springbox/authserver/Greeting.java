package io.springbox.authserver;

/**
 * Created by vcarvalho on 5/4/15.
 */
public class Greeting {


    public Greeting(){}

    public Greeting(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String content;

}
