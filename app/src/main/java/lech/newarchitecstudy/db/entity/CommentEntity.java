package lech.newarchitecstudy.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

import lech.newarchitecstudy.model.Comment;

/**
 * Created by Android_61 on 2017/7/3.
 * Description
 * Others
 */

@Entity(tableName = "comments", foreignKeys = {
        @ForeignKey(entity = ProductEntity.class,
                parentColumns = "id",
                childColumns = "productId",
                onDelete = ForeignKey.CASCADE
        )}, indices = {
        @Index(value = "productId")

})


public class CommentEntity implements Comment {

    @PrimaryKey(autoGenerate = true)
    private int    id;
    private int    productId;
    private String text;
    private Date   postedAt;

    @Override
    public int getId() {

        return id;
    }

    @Override
    public int getProductId() {
        return productId;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public Date getPostedAt() {
        return postedAt;
    }

    public CommentEntity() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setPostedAt(Date postAt) {
        this.postedAt = postAt;
    }

    private CommentEntity(Comment comment) {
        this.id = comment.getId();
        this.productId = comment.getProductId();
        this.text = comment.getText();
        this.postedAt = comment.getPostedAt();


    }
}
