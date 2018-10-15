const SERVICE = {
    loadLabel: 'http://localhost/labels',
    addLabel: 'http://localhost/label',
    updateLabel: 'http://localhost/label',
    deleteLabel:'http://localhost/label/delete',
};


const messageBox = (function(){
    function addBox(){
        let box = document.querySelector('#messageBox');
        let height = document.body.clientHeight/2;
        if(!box){
            box = document.createElement("div");
            box.id = "messageBox";
            document.body.appendChild(box);
            box.style.padding = "8px 10px";
            box.style.position = "absolute";
            box.style.zIndex = "9999";
            box.style.top = `calc(50% + ${height}px)`;
            box.style.left = "50%";
        }
        box.style.display = "block";
        return box;
    }

    function success(message){
        let box = addBox();
        box.style.backgroundColor = "#f0f0f0";
        box.innerHTML = message;
        setTimeout(()=>{
            box.style.display = "none";
        },500);


    }
    function error(message){
        let box = addBox();
        box.style.backgroundColor = "red";
        box.innerHTML = message;
        setTimeout(()=>{
            box.style.display = "none";
        },500)
    }

    return {
        success,
        error
    }
})();