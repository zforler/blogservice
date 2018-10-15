$(function(){
    loadLabel();
    addLabel();
    updateLabel();
    deleteLabel();
})

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

function addLabel(){
    $('#ok-btn').click(()=>{
        let name = $('#label-input').val().trim();
        if(!name){
            messageBox.error("标签名称不能为空");
        }else{
            $.ajax({
                url: SERVICE.addLabel,
                data:{append:name},
                type: "PUT"
            }).done((data)=>{
                console.log(data);
                if(1 == data.code){
                    messageBox.success("添加成功");
                    loadLabel();
                }else{
                    messageBox.error(data.msg);
                }
            })
        }
    })
}

function createLabelList(data){
    let str = "";
    data.forEach((label)=>{
        str += `<li class="article-label" data-id="${label.id}">${label.append}</li>`;
    });
    $("#label-ul").html(str);
}

function updateLabel(){
    $('#label-ul').dblclick((e)=>{
        console.log(e);
        let target = e.target;
        if("LI" === target.nodeName){
            let text = $(target).text();
            let id= $(target).attr('data-id');
            console.log(text);
            $(target).html(`<input id="temp-label" value="${text}"/>`);
            $('#temp-label').blur(function(){
                let labelName = $(this).val();
                $.ajax({
                    url: SERVICE.updateLabel,
                    data:{append:labelName,id:id},
                    type:'POST',
                    success:(data)=>{
                        console.log(data);
                        if(1 == data.code){
                            messageBox.success("更新成功");
                            loadLabel();
                        }else{
                            messageBox.error(data.msg);
                        }
                    }
                })

            });
        }
    });
}

function deleteLabel(){
    let id = "";
    $('#label-ul').click((e)=>{
        console.log(e);
        let target = e.target;
        if("LI" === target.nodeName){
            id= $(target).attr('data-id');
            $('.article-label-select').removeClass('article-label-select');
            $(target).addClass('article-label-select');
        }
    });

    $("#delete-btn").click(()=>{
        if(!id){
            messageBox.error("为选择标签");
        }else{
            $.ajax({
                url: SERVICE.deleteLabel,
                type: 'POST',
                data:{id:id},
            }).done((data)=>{
                console.log(data);
                if(1 == data.code){
                    messageBox.success("删除新成功");
                    loadLabel();
                }else{
                    messageBox.error(data.msg);
                }
            });

        }
    })
}