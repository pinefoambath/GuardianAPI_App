
package com.example.android.guardianapp;

/**
 * An {@link Article} object contains information related to a single article.
 */
public class Article {

    /** section of the article*/
    private String mSectionID;

    /** title of the Article*/
    private String mWebTitle;

    /** Time of the Article*/
    private String mWebPublicationDate;

    /** Website URL of the Article*/
    private String mWebUrl;

     public Article (String sectionID, String webPublicationDate, String webTitle, String webUrl){

         mSectionID=sectionID;
         mWebPublicationDate=webPublicationDate;
         mWebTitle=webTitle;
         mWebUrl=webUrl;
     }

    /**
     * Returns the section the article is in.
     */
    public String getSectionID() {
        return mSectionID;
    }

    /**
     * Returns the publication date of the article
     */
    public String getWebPublicationDate() {
        return mWebPublicationDate;
    }

    /**
     * Returns the title of the article
     */
    public String getWebTitle() {
        return mWebTitle;
    }

    /**
     * Returns the website URL to find more information about the article.
     */
    public String getWebUrl() {
        return mWebUrl;
    }
}
