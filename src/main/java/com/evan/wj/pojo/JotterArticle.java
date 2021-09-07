package com.evan.wj.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "jotter_article", schema = "wj", catalog = "")
public class JotterArticle {
    private int id;
    private String articleTitle;
    private String articleContentHtml;
    private String articleContentMd;
    private String articleAbstract;
    private String articleCover;
    private Timestamp articleDate;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "article_title")
    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    @Basic
    @Column(name = "article_content_html")
    public String getArticleContentHtml() {
        return articleContentHtml;
    }

    public void setArticleContentHtml(String articleContentHtml) {
        this.articleContentHtml = articleContentHtml;
    }

    @Basic
    @Column(name = "article_content_md")
    public String getArticleContentMd() {
        return articleContentMd;
    }

    public void setArticleContentMd(String articleContentMd) {
        this.articleContentMd = articleContentMd;
    }

    @Basic
    @Column(name = "article_abstract")
    public String getArticleAbstract() {
        return articleAbstract;
    }

    public void setArticleAbstract(String articleAbstract) {
        this.articleAbstract = articleAbstract;
    }

    @Basic
    @Column(name = "article_cover")
    public String getArticleCover() {
        return articleCover;
    }

    public void setArticleCover(String articleCover) {
        this.articleCover = articleCover;
    }

    @Basic
    @Column(name = "article_date")
    public Timestamp getArticleDate() {
        return articleDate;
    }

    public void setArticleDate(Timestamp articleDate) {
        this.articleDate = articleDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JotterArticle that = (JotterArticle) o;
        return id == that.id &&
                Objects.equals(articleTitle, that.articleTitle) &&
                Objects.equals(articleContentHtml, that.articleContentHtml) &&
                Objects.equals(articleContentMd, that.articleContentMd) &&
                Objects.equals(articleAbstract, that.articleAbstract) &&
                Objects.equals(articleCover, that.articleCover) &&
                Objects.equals(articleDate, that.articleDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, articleTitle, articleContentHtml, articleContentMd, articleAbstract, articleCover, articleDate);
    }
}
