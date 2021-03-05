package com.myfirst.restdemo.rest;

public class GithubConfig {
    public static final String GITHUB_ACCEPT = "application/vnd.github.inertia-preview+json";
    //public static final String GITHUB_AUTH_TOKEN = "token 70a22a7151b5ad3b83ff89d14b35483311427249";
    public static final String GITHUB_AUTH_TOKEN = "token 9b09f48c82d1622468db0b874eb9c1549cc579dc";
    public static final String GITHUB_API_PROJECT_TOPICS = "/repos/{owner}/{repo}/topics";
    public static final String GITHUB_API_BASE_URL = "https://api.github.com/";
    public static final String GITHUB_API_REPOS = "users/{user}/repos";
    public static final String GITHUB_API_CREATE_PROJECT = "/user/projects";
    public static final String GITHUB_API_DELETE_OWNER = "/repos/{owner}/{repo}";
    public static final String GITHUB_API_ADD_WRITER = "/projects/{project_id}/collaborators/{username}";
}
