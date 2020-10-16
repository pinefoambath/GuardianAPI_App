
package com.example.android.guardianappVersionFive;

/**
 * An {@link Article} object contains information related to a single article.
 */
public class Article {

    /**
     * section of the article
     */
    private String mSectionId;

    /**
     * title of the Article
     */
    private String mWebTitle;

    /**
     * Time of the Article
     */
    private String mWebPublicationDate;

    /**
     * Website URL of the Article
     */
    private String mWebUrl;

    /**
     * name of the author
     */
    private String mNewsAuthor;


    public Article(String sectionId, String webPublicationDate, String webTitle, String webUrl, String newsAuthor) {

        mWebPublicationDate = webPublicationDate;
        mWebTitle = webTitle;
        mWebUrl = webUrl;
        mNewsAuthor = newsAuthor;
        mSectionId = sectionId;
    }

    /**
     * Returns the section the article is in.
     */
    public String getSectionId() {
        return mSectionId;
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

    /**
     * Returns the name of the Author if available.
     */

    public String getNewsAuthor() {
        return mNewsAuthor;
    }
}
