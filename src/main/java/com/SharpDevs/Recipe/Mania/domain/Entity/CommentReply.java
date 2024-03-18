package com.SharpDevs.Recipe.Mania.domain.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Set;
//
//@Entity
//@Table
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class CommentReply extends CommentEntity{

    private Long comment_id;

    private Set<CommentReply> commentReplies;
}
