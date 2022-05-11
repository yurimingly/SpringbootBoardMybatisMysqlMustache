var main = {
    init : function () {
        var _this = this;
        $('#btn-create').on('click', function () {
            _this.create();
        });

        $('#btn-update').on('click', function () {
            _this.update();
        });

        $('#btn-delete').on('click', function () {
            _this.delete();
        });
    },

    //글쓰기
    create : function () {
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };
        $.ajax({
            type: 'POST',
            url: '/posts/create',
            dataType: 'text',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert('글 등록에 실패하였습니다. 새로고침 후 재시도하세요.');
            //console.log(JSON.stringify(error));
        });
    },

    //글수정
    update : function () {
        var data = {
            idx: $('#idx').val(),
            title: $('#title').val(),
            content: $('#content').val()
        };
        var idx = $('#idx').val();

        $.ajax({
            type: 'PATCH',
            url: '/posts/update/'+idx,
            dataType: 'text',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 수정되었습니다.');
            window.location.href = '/';
        }).fail(function (error) { //request,status,error
            console.log(JSON.stringify(error));
            /*console.log("idx - "+ idx);
            console.log("title - "+ data.title);
            console.log("content - "+ data.content);*/
            //console.log("code:"+request.status+"\n"+"\n"+"///message:"+request.responseText+"\n"+"\n"+"///error:"+error);
        });
    },

    //글삭제
    delete : function () {
        var idx = $('#idx').val();

        $.ajax({
            type: 'DELETE',
            url: '/posts/delete/'+idx,
            dataType: 'json',
            contentType:'application/json; charset=utf-8'
        }).done(function() {
            alert('글이 삭제되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }

};

main.init();