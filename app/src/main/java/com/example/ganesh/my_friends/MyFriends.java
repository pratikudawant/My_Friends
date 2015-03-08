package com.example.ganesh.my_friends;

/**
 * Created by Ganesh on 15-02-23.
 */
public class MyFriends {


        private String phone;
        private String FriendName;
        private String FriendEmail;
         private int id;

        public MyFriends() {
        }

        public MyFriends (String FriendName, String phone, String FriendEmail){
            this.FriendName = FriendName;
            this.FriendEmail = FriendEmail;
            this.phone =phone;
        }

        public MyFriends (int id, String FriendName, String phone, String FriendEmail){
            this.id = id;
            this.FriendName = FriendName;
            this.FriendEmail = FriendEmail;
            this.phone =phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getPhone() {
            return this.phone;
        }

        public void setFriendName(String FriendName){
            this.FriendName = FriendName;
        }

        public String getFriendName(){
            return this.FriendName;
        }

        public void setFriendEmail(String FriendEmail){
            this.FriendEmail = FriendEmail;
        }

        public String getFriendEmail(){
            return this.FriendEmail;
        }

        public int getId() {return id;}

         public void setId(int id) {
        this.id = id;
    }

}
