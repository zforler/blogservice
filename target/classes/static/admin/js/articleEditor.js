$(function(){
    let ue = UE.getEditor('editor');
    ue.addListener( 'ready', function( editor ) {
        articleSend(ue);
        articleSave(ue);
        getArticleDetail(ue);
    } );

    loadLabel();

});


/**
 * 文章发表
 */
function articleSend(editor){
    $('#article-send').click(function(){
        let articleInfo = getArticleInfo(editor);

        $.ajax({
            url:'http://localhost/article',
            type:"POST",
            data: articleInfo
        }).done((data)=>{
            console.log(data)
            if(1 == data.code){
                messageBox.success("发布成功");
            }else{
                messageBox.error(data.msg)
            }
        })
    });
}

/**
 * 文章保存
 */
function articleSave(editor){
    $('#article-save').click(function(){
        console.log('save')
        let articleInfo = getArticleInfo(editor);
        articleInfo.status = 1;

        $.ajax({
            url:'localhost/article',
            type:"POST",
            headers:{
                "content-type":"application/json charset=utf-8",
            },
            data:articleInfo
        }).done((data)=>{
            console.log(data)
            if(1 == data.code){

            }
        })
    });
}

/**
 * 获取文章信息
 */
function getArticleInfo(editor){
    let content = editor.getContent();
    let reg = /<img src=".*?picture\/(.*?)".*?\/>/g;
    let img = [];
    let temp;
    while(temp = reg.exec(content)){
        img.push(temp[1]);
    }
    console.log(img);
    let label = [];
    $('.label-item').each(function(){
        if($(this).is(':checked')){
            console.log($(this).val());
            label.push($(this).val());
        }
    });
    label = label.join();
    console.log(label);
    return {
        title: $('#article-title').val(),
        content : editor.getContent(),
        keyword : $("#article-keyword").val(),
        type : $("#article-type").val(),
        reviewswitch : $("#article-comment").val(),
        img:img.join('|'),
        articlePrivate: $("#article-private").val(),
        label: label,
    }
}

function loadLabel(){
    $.ajax({
        url: SERVICE.loadLabel,
    }).done((data)=>{
        console.log(data);
        if(1 == data.code){
            createLabelList(JSON.parse(data.data));
        }else{
            messageBox.error(data.msg);
        }
    });
}

function createLabelList(data){
    let str = "";
    data.forEach((label)=>{
        str += `<input type="checkbox" class="label-item" name="like1[write]" lay-skin="primary" value="${label.id}" title="${label.append}">`;
    });
    $("#articel-label").html(str);
}

function getArticleDetail(editor){
    let articleId = window.sessionStorage.getItem('articleId');
    if(!articleId){
        console.error('没有文章id')
        return ;
    }
    console.log(articleId)
    $.ajax({
        url: 'http://localhost/article',
        data: { articleId: articleId },
        success: rep => {
            console.log(rep)
            let data = rep.data;
            if(!data){
                console.error(`为获取到id为${articleId}的文章详情`)
                return;
            }
            $('#article-title').val(data.title);
            editor.setContent(data.content);
            $('#article-keyword').val(data.keyword);
        }
    })
}