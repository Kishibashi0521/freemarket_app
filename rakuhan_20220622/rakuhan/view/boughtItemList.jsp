<!--<%@page contentType="text/html;charset=UTF-8" %>-->

<!--島津作成 -->
<html>
    <head>
        <title>購入済み商品リスト</title>
    </head>
    <body>
        <!--<%@include file= "/common/header.jsp"%>-->
            <table align="center" width="850">
            <tr>
                <td width="80">[<!--リンク-->ログイン</a>]</td>
                <td width="80">[<!--リンク-->メニュー</a>]</td>
                <td width="508" align="center" ><font size="5">購入済み商品リスト</font></td>
                <td width="80">&nbsp;</td>
                <td width="80">&nbsp;</td>
            </tr>
            </table>

        <hr align="center" size="2" color="black" width="950"></hr>

        <form action="<!--登録リンク-->">
            <table style="margin: 0 auto">
                <tr>
                    <td bgcolor="#39F"style="width: 60">商品名</td>
                    <td>時計</td>

                    <td bgcolor="#39F"style="width: 60">金額</td>
                    <td>￥20,000</td>

                    <td colspan=2 style="text-align: center">
                    <input type="submit"value="入金画面に行く"></td>
                </tr>
                </table>
                <form action="<!--登録リンク-->">
                <table style="margin: 0 auto">
                <tr>
                    <td colspan=2 style="text-align: center">
                    <input type="submit"value="取引完了しました"></td>
                </tr>
            </table>
        </form>
        <!--<%@include file= "/common/footer.jsp"%>-->
    </body>
</html>