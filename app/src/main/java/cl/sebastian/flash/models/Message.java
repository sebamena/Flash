package cl.sebastian.flash.models;

/**
 * Created by Sebastián Mena on 14-09-2017.
 */

public class Message {

    private String content, owner;

    public Message() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
