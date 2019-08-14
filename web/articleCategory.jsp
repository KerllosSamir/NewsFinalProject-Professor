<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="left_content">
    <div class="single_post_content">
        <h2><span>${categoryArticles[0].categoryName}</span></h2>
        <div class="single_post_content_left">
            <ul class="business_catgnav">
                <li>
                    <figure class="bsbig_fig  wow fadeInDown animated"
                            style="visibility: visible; animation-name: fadeInDown;">
                        <a class="featured_img" href="frontarticle?id=${categoryArticles[0].id}">
                            <img src="${categoryArticles[0].mainImage}" alt=""> <span class="overlay"></span> </a>
                        <figcaption><a href="frontarticle?id=${categoryArticles[0].id}">${categoryArticles[0].title}</a>
                        </figcaption>
                        <p>${categoryArticles[0].body}...</p>
                    </figure>
                </li>
            </ul>
        </div>
        <div class="single_post_content_right">
            <ul class="spost_nav">
                <c:forEach items="${categoryArticles}" var="article" varStatus="loop">
                    <c:if test="${not loop.first}">
                        <li>
                            <div class="media wow fadeInDown animated"
                                 style="visibility: visible; animation-name: fadeInDown;">
                                <a href="frontarticle?id=${article.id}" class="media-left">
                                    <img alt="" src="${article.mainImage}">
                                </a>
                                <div class="media-body"><a href="frontarticle?id=${article.id}"
                                                           class="catg_title"> ${article.title}</a></div>
                            </div>
                        </li>
                    </c:if>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>
