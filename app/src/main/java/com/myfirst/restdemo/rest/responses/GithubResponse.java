package com.myfirst.restdemo.rest.responses;

import com.google.gson.annotations.SerializedName;

// response from GITHUB_API_BASE_URL
public class GithubResponse {
    //todo add fields
    @SerializedName("current_user_url")
    public String currentUserUrl;
    @SerializedName("current_user_authorizations_html_url")
    public String currentUserAuthorizationsHtmlUrl;
    @SerializedName("authorizations_url")
    public String authorizationsUrl;
    @SerializedName("code_search_url")
    public String codeSearchUrl;
    @SerializedName("commit_search_url")
    public String commitSearchUrl;
    @SerializedName("emails_url")
    public String emailsUrl;
    @SerializedName("emojis_url")
    public String emojisUrl;
    @SerializedName("events_url")
    public String eventsUrl;
    @SerializedName("feeds_url")
    public String feedsUrl;
    @SerializedName("followers_url")
    public String followersUrl;
    @SerializedName("following_url")
    public String followingUrl;
    @SerializedName("gists_url")
    public String gistsUrl;
    @SerializedName("hub_url")
    public String hubUrl;
    @SerializedName("issue_search_url")
    public String issueSearchUrl;
    @SerializedName("issues_url")
    public String issuesUrl;
    @SerializedName("keys_url")
    public String keysUrl;
    @SerializedName("label_search_url")
    public String labelSearchUrl;
    @SerializedName("notifications_url")
    public String notificationsUrl;
    @SerializedName("organization_url")
    public String organizationUrl;
    @SerializedName("organization_repositories_url")
    public String organizationRepositoriesUrl;
    @SerializedName("organization_teams_url")
    public String organizationTeamsUrl;
    @SerializedName("public_gists_url")
    public String publicGistsUrl;
    @SerializedName("rate_limit_url")
    public String rateLimitUrl;
    @SerializedName("repository_url")
    public String repositoryUrl;
    @SerializedName("repository_search_url")
    public String repositorySearchUrl;
    @SerializedName("current_user_repositories_url")
    public String currentUserRepositoriesUrl;
    @SerializedName("starred_url")
    public String starredUrl;
    @SerializedName("starred_gists_url")
    public String starredGistsUrl;
    @SerializedName("user_url")
    public String userUrl;
    @SerializedName("user_organizations_url")
    public String userOrganizationsUrl;
    @SerializedName("user_repositories_url")
    public String userRepositoriesUrl;
    @SerializedName("user_search_url")
    public String userSearchUrl;

    @Override
    public String toString() {
        return "GithubResponse{ " + "\n" +
                "currentUserUrl = " + currentUserUrl + ',' + '\n' +
                "currentUserAuthorizationsHtmlUrl = " + currentUserAuthorizationsHtmlUrl + ',' + '\n' +
                "authorizationsUrl = " + authorizationsUrl + ',' + '\n' +
                "codeSearchUrl = " + codeSearchUrl + ',' + '\n' +
                "commitSearchUrl = " + commitSearchUrl + ',' + '\n' +
                "emailsUrl = " + emailsUrl + ',' + '\n' +
                "emojisUrl = " + emojisUrl + ',' + '\n' +
                "eventsUrl = " + eventsUrl + ',' + '\n' +
                "feedsUrl = " + feedsUrl + ',' + '\n' +
                "followersUrl = " + followersUrl + ',' + '\n' +
                "followingUrl = " + followingUrl + ',' + '\n' +
                "gistsUrl = " + gistsUrl + ',' + '\n' +
                "hubUrl = " + hubUrl + ',' + '\n' +
                "issueSearchUrl = " + issueSearchUrl + ',' + '\n' +
                "issuesUrl = " + issuesUrl + ',' + '\n' +
                "keysUrl = " + keysUrl + ',' + '\n' +
                "labelSearchUrl = " + labelSearchUrl + ',' + '\n' +
                "notificationsUrl = " + notificationsUrl + ',' + '\n' +
                "organizationUrl = " + organizationUrl + ',' + '\n' +
                "organizationRepositoriesUrl = " + organizationRepositoriesUrl + ',' + '\n' +
                "organizationTeamsUrl = " + organizationTeamsUrl + ',' + '\n' +
                "publicGistsUrl = " + publicGistsUrl + ',' + '\n' +
                "rateLimitUrl = " + rateLimitUrl + ',' + '\n' +
                "repositoryUrl = " + repositoryUrl + ',' + '\n' +
                "repositorySearchUrl = " + repositorySearchUrl + ',' + '\n' +
                "currentUserRepositoriesUrl = " + currentUserRepositoriesUrl + ',' + '\n' +
                "starredUrl = " + starredUrl + ',' + '\n' +
                "starredGistsUrl = " + starredGistsUrl + ',' + '\n' +
                "userUrl = " + userUrl + ',' + '\n' +
                "userOrganizationsUrl = " + userOrganizationsUrl + ',' + '\n' +
                "userRepositoriesUrl = " + userRepositoriesUrl + ',' + '\n' +
                "userSearchUrl = " + userSearchUrl + ',' + '\n' +
                '}';
    }

    /*@SerializedName("current_user_url")
    public String getCurrentUserUrl() {
        return currentUserUrl;
    }

    @SerializedName("current_user_url")
    public void setCurrentUserUrl(String currentUserUrl) {
        this.currentUserUrl = currentUserUrl;
    }

    @SerializedName("current_user_authorizations_html_url")
    public String getCurrentUserAuthorizationsHtmlUrl() {
        return currentUserAuthorizationsHtmlUrl;
    }

    @SerializedName("current_user_authorizations_html_url")
    public void setCurrentUserAuthorizationsHtmlUrl(String currentUserAuthorizationsHtmlUrl) {
        this.currentUserAuthorizationsHtmlUrl = currentUserAuthorizationsHtmlUrl;
    }

    @SerializedName("authorizations_url")
    public String getAuthorizationsUrl() {
        return authorizationsUrl;
    }

    @SerializedName("authorizations_url")
    public void setAuthorizationsUrl(String authorizationsUrl) {
        this.authorizationsUrl = authorizationsUrl;
    }

    @SerializedName("code_search_url")
    public String getCodeSearchUrl() {
        return codeSearchUrl;
    }

    @SerializedName("code_search_url")
    public void setCodeSearchUrl(String codeSearchUrl) {
        this.codeSearchUrl = codeSearchUrl;
    }

    @SerializedName("commit_search_url")
    public String getCommitSearchUrl() {
        return commitSearchUrl;
    }

    @SerializedName("commit_search_url")
    public void setCommitSearchUrl(String commitSearchUrl) {
        this.commitSearchUrl = commitSearchUrl;
    }

    @SerializedName("emails_url")
    public String getEmailsUrl() {
        return emailsUrl;
    }

    @SerializedName("emails_url")
    public void setEmailsUrl(String emailsUrl) {
        this.emailsUrl = emailsUrl;
    }

    @SerializedName("emojis_url")
    public String getEmojisUrl() {
        return emojisUrl;
    }

    @SerializedName("emojis_url")
    public void setEmojisUrl(String emojisUrl) {
        this.emojisUrl = emojisUrl;
    }

    @SerializedName("events_url")
    public String getEventsUrl() {
        return eventsUrl;
    }

    @SerializedName("events_url")
    public void setEventsUrl(String eventsUrl) {
        this.eventsUrl = eventsUrl;
    }

    @SerializedName("feeds_url")
    public String getFeedsUrl() {
        return feedsUrl;
    }

    @SerializedName("feeds_url")
    public void setFeedsUrl(String feedsUrl) {
        this.feedsUrl = feedsUrl;
    }

    @SerializedName("followers_url")
    public String getFollowersUrl() {
        return followersUrl;
    }

    @SerializedName("followers_url")
    public void setFollowersUrl(String followersUrl) {
        this.followersUrl = followersUrl;
    }

    @SerializedName("following_url")
    public String getFollowingUrl() {
        return followingUrl;
    }

    @SerializedName("following_url")
    public void setFollowingUrl(String followingUrl) {
        this.followingUrl = followingUrl;
    }

    @SerializedName("gists_url")
    public String getGistsUrl() {
        return gistsUrl;
    }

    @SerializedName("gists_url")
    public void setGistsUrl(String gistsUrl) {
        this.gistsUrl = gistsUrl;
    }

    @SerializedName("hub_url")
    public String getHubUrl() {
        return hubUrl;
    }

    @SerializedName("hub_url")
    public void setHubUrl(String hubUrl) {
        this.hubUrl = hubUrl;
    }

    @SerializedName("issue_search_url")
    public String getIssueSearchUrl() {
        return issueSearchUrl;
    }

    @SerializedName("issue_search_url")
    public void setIssueSearchUrl(String issueSearchUrl) {
        this.issueSearchUrl = issueSearchUrl;
    }

    @SerializedName("issues_url")
    public String getIssuesUrl() {
        return issuesUrl;
    }

    @SerializedName("issues_url")
    public void setIssuesUrl(String issuesUrl) {
        this.issuesUrl = issuesUrl;
    }

    @SerializedName("keys_url")
    public String getKeysUrl() {
        return keysUrl;
    }

    @SerializedName("keys_url")
    public void setKeysUrl(String keysUrl) {
        this.keysUrl = keysUrl;
    }

    @SerializedName("label_search_url")
    public String getLabelSearchUrl() {
        return labelSearchUrl;
    }

    @SerializedName("label_search_url")
    public void setLabelSearchUrl(String labelSearchUrl) {
        this.labelSearchUrl = labelSearchUrl;
    }

    @SerializedName("notifications_url")
    public String getNotificationsUrl() {
        return notificationsUrl;
    }

    @SerializedName("notifications_url")
    public void setNotificationsUrl(String notificationsUrl) {
        this.notificationsUrl = notificationsUrl;
    }

    @SerializedName("organization_url")
    public String getOrganizationUrl() {
        return organizationUrl;
    }

    @SerializedName("organization_url")
    public void setOrganizationUrl(String organizationUrl) {
        this.organizationUrl = organizationUrl;
    }

    @SerializedName("organization_repositories_url")
    public String getOrganizationRepositoriesUrl() {
        return organizationRepositoriesUrl;
    }

    @SerializedName("organization_repositories_url")
    public void setOrganizationRepositoriesUrl(String organizationRepositoriesUrl) {
        this.organizationRepositoriesUrl = organizationRepositoriesUrl;
    }

    @SerializedName("organization_teams_url")
    public String getOrganizationTeamsUrl() {
        return organizationTeamsUrl;
    }

    @SerializedName("organization_teams_url")
    public void setOrganizationTeamsUrl(String organizationTeamsUrl) {
        this.organizationTeamsUrl = organizationTeamsUrl;
    }

    @SerializedName("public_gists_url")
    public String getPublicGistsUrl() {
        return publicGistsUrl;
    }

    @SerializedName("public_gists_url")
    public void setPublicGistsUrl(String publicGistsUrl) {
        this.publicGistsUrl = publicGistsUrl;
    }

    @SerializedName("rate_limit_url")
    public String getRateLimitUrl() {
        return rateLimitUrl;
    }

    @SerializedName("rate_limit_url")
    public void setRateLimitUrl(String rateLimitUrl) {
        this.rateLimitUrl = rateLimitUrl;
    }

    @SerializedName("repository_url")
    public String getRepositoryUrl() {
        return repositoryUrl;
    }

    @SerializedName("repository_url")
    public void setRepositoryUrl(String repositoryUrl) {
        this.repositoryUrl = repositoryUrl;
    }

    @SerializedName("repository_search_url")
    public String getRepositorySearchUrl() {
        return repositorySearchUrl;
    }

    @SerializedName("repository_search_url")
    public void setRepositorySearchUrl(String repositorySearchUrl) {
        this.repositorySearchUrl = repositorySearchUrl;
    }

    @SerializedName("current_user_repositories_url")
    public String getCurrentUserRepositoriesUrl() {
        return currentUserRepositoriesUrl;
    }

    @SerializedName("current_user_repositories_url")
    public void setCurrentUserRepositoriesUrl(String currentUserRepositoriesUrl) {
        this.currentUserRepositoriesUrl = currentUserRepositoriesUrl;
    }

    @SerializedName("starred_url")
    public String getStarredUrl() {
        return starredUrl;
    }

    @SerializedName("starred_url")
    public void setStarredUrl(String starredUrl) {
        this.starredUrl = starredUrl;
    }

    @SerializedName("starred_gists_url")
    public String getStarredGistsUrl() {
        return starredGistsUrl;
    }

    @SerializedName("starred_gists_url")
    public void setStarredGistsUrl(String starredGistsUrl) {
        this.starredGistsUrl = starredGistsUrl;
    }

    @SerializedName("user_url")
    public String getUserUrl() {
        return userUrl;
    }

    @SerializedName("user_url")
    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }

    @SerializedName("user_organizations_url")
    public String getUserOrganizationsUrl() {
        return userOrganizationsUrl;
    }

    @SerializedName("user_organizations_url")
    public void setUserOrganizationsUrl(String userOrganizationsUrl) {
        this.userOrganizationsUrl = userOrganizationsUrl;
    }

    @SerializedName("user_repositories_url")
    public String getUserRepositoriesUrl() {
        return userRepositoriesUrl;
    }

    @SerializedName("user_repositories_url")
    public void setUserRepositoriesUrl(String userRepositoriesUrl) {
        this.userRepositoriesUrl = userRepositoriesUrl;
    }

    @SerializedName("user_search_url")
    public String getUserSearchUrl() {
        return userSearchUrl;
    }

    @SerializedName("user_search_url")
    public void setUserSearchUrl(String userSearchUrl) {
        this.userSearchUrl = userSearchUrl;
    }*/
}
