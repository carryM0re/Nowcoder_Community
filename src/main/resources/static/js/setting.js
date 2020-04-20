$(function () { // $(function)表明页面加载完成就要完成这个函数
    $("#uploadForm").submit(upload); // 当点击提交按钮，触发表单的提交事件时，用upload处理
});

function upload() {
    $.ajax({  // $.post是ajax的简化
        url: "http://upload-z2.qiniup.com",
        method: "post",
        processData: false, // 不要把表单内容转为字符串
        contentType: false, // 不让jQuery设置上传类型，边界就好界定，否则不好界定
        data: new FormData($("#uploadForm")[0]),
        success: function (data) {
            if (data && data.code == 0) {
                // 更新头像访问路径
                $.post(
                    CONTEXT_PATH + "/user/header/url",
                    {"fileName": $("input[name='key']").val()},
                    function (data) {
                        data = $.parseJSON(data);
                        if (data.code == 0) {
                            window.location.reload();
                        } else {
                            alert(data.msg);
                        }
                    }
                );
            } else {
                alert("上传失败！")
            }
        }
    });

    return false; // 表示不要再进行提交了，上面的逻辑已经处理了
}