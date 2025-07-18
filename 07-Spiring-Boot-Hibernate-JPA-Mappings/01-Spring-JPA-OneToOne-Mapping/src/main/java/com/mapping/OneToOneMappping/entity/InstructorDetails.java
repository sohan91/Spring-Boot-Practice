package com.mapping.OneToOneMappping.entity;

import jakarta.persistence.*;

@Entity
@Table(name="instructor_details")
public class InstructorDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="Youtube_Channel")
    private String youtubeChannel;

    @Column(name="hobby")
    private String hobby;

    @OneToOne(mappedBy = "instructorDetails",
              cascade = CascadeType.ALL)
    private Instructor instructor;

    public void setInstructor(Instructor instructor)
    {
        this.instructor = instructor;
    }

    public Instructor getInstructor()
    {
        return instructor;
    }

    public InstructorDetails(String youtubeChannel,String hobby)
    {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }
    public InstructorDetails()
    {

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "InstructorDetails{" +
                "id=" + id +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
