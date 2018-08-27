    package com.kg.boook.model;

    import javax.persistence.CascadeType;
    import javax.persistence.Column;
    import javax.persistence.Entity;
    import javax.persistence.FetchType;
    import javax.persistence.GeneratedValue;
    import javax.persistence.GenerationType;
    import javax.persistence.Id;
    import javax.persistence.JoinColumn;
    import javax.persistence.ManyToOne;
    import javax.persistence.OneToMany;
    import javax.persistence.Table;

    @Entity

    public class BookRequest{

    // bookreqid,userid, userid, status (Q/I/R)

    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        private Long bookreqid;

    @Column

    private Long userid;

    @Column String category;

    @Column

    private String book;

        @Column

    private String status;
    /**

    * @return the bookreqid

    */

    public Long getBookreqid() {

    return bookreqid;

    }

    /**

    * @param bookreqid the bookreqid to set

    */

    public void setBookreqid(Long bookreqid) {

    this.bookreqid = bookreqid;

    }

    /**

    * @return the userid

    */

    public Long getUserid() {

    return userid;

    }

    /**

    * @param userid the userid to set

    */

    public void setUserid(Long userid) {

    this.userid = userid;

    }

    /**

    * @return the category

    */

    public String getCategory() {

    return category;

    }

    /**

    * @param category the category to set

    */

    public void setCategory(String category) {

    this.category = category;

    }

    /**

    * @return the book

    */

    public String getBook() {

    return book;

    }

    /**

    * @param book the book to set

    */

    public void setBook(String book) {

    this.book = book;

    }

    

    /**

    * @return the status

    */

    public String getStatus() {

    return status;

    }

    /**

    * @param status the status to set

    */

    public void setStatus(String status) {

    this.status = status;

    }




    @Override

    public String toString() {

    return bookreqid+" "+book+" "+category+" "+status+" "+userid;

    

    }

    }

