$(function () {
    loadArticles();
});



function loadArticles(){
    $.ajax({
        url: 'http://localhost/articles',
        type: 'GET',
        data:{pageNum:0},
    }).done((data)=>{
        let articles = data.data;
        console.log(data);
        createArticleList(articles);
    });
}

function createArticleList(articles){
    let temp = '',
        article = null;
    for(let i = 0, len = articles.length; i < len; i++){
        article = articles[i];
        let date = new Date(parseInt(article.createtime)*1000);

        temp += `<li class="article" data-id="${article.id}">
                    <span class="article-title">${article.title}</span>
                    <span class="article-time">${formatDate(date,'yyyy-MM-dd') }</span>
                    <span class="article-view">${article.upvotecount}</span>
                </li>`
    }

    $("#articleList").html(temp);
    $('.article').click(function(){
        $('a[href-url=\'page/articleEditor.html\']', parent.document).parent().click();
        window.sessionStorage.setItem('articleId',$(this).attr('data-id'))
    })
}
function formatDate(date,fmt) {
    if(/(y+)/.test(fmt)){
        fmt = fmt.replace(RegExp.$1,(date.getFullYear()+'').substr(4-RegExp.$1.length));
    }
    let o = {
        'M+':date.getMonth() + 1,
        'd+':date.getDate(),
        'h+':date.getHours(),
        'm+':date.getMinutes(),
        's+':date.getSeconds()
    };

    // 遍历这个对象
    for(let k in o){
        if(new RegExp(`(${k})`).test(fmt)){
            let str = o[k] + '';
            fmt = fmt.replace(RegExp.$1,(RegExp.$1.length===1)?str:padLeftZero(str));
        }
    }
    return fmt;
};

function padLeftZero(str) {
    return ('00'+str).substr(str.length);
}