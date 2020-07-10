package com.keduw.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "kd_note_term_member", schema = "keduw", catalog = "")
public class KdNoteTermMemberEntity {
    private int id;
    private int termId;
    private int userId;
    private Timestamp joinTime;
    private int flag;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "term_id")
    public int getTermId() {
        return termId;
    }

    public void setTermId(int termId) {
        this.termId = termId;
    }

    @Basic
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "join_time")
    public Timestamp getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Timestamp joinTime) {
        this.joinTime = joinTime;
    }

    @Basic
    @Column(name = "flag")
    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KdNoteTermMemberEntity that = (KdNoteTermMemberEntity) o;
        return id == that.id &&
                termId == that.termId &&
                userId == that.userId &&
                flag == that.flag &&
                Objects.equals(joinTime, that.joinTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, termId, userId, joinTime, flag);
    }
}
