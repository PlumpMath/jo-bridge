<map version="0.9.0">
<!-- To view this file, download free mind mapping software FreeMind from http://freemind.sourceforge.net -->
<node CREATED="1267975422358" ID="ID_1117521085" MODIFIED="1267975478597" TEXT="Jo-bridge">
<font BOLD="true" NAME="SansSerif" SIZE="12"/>
<node CREATED="1267975481048" ID="ID_1761609974" MODIFIED="1267978616927" POSITION="right" TEXT="Architecture">
<icon BUILTIN="info"/>
<node CREATED="1267976754155" ID="ID_253229835" MODIFIED="1267976758139">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <img src="jo-bridge-architecture.png" />
  </body>
</html></richcontent>
</node>
<node CREATED="1267976766484" ID="ID_893120982" MODIFIED="1267978618000" TEXT="Responsibilities">
<icon BUILTIN="messagebox_warning"/>
<node CREATED="1267976771868" FOLDED="true" ID="ID_275845431" MODIFIED="1267978762815" TEXT="IScriptBridge">
<node CREATED="1267976786621" ID="ID_1438523300" MODIFIED="1267976811568" TEXT="Interface for (potentially) any interpreter"/>
<node CREATED="1267976814070" ID="ID_1927247979" MODIFIED="1267976913983" TEXT="it is the layer between OSGi platform and &#xa;the real interpreter component"/>
<node CREATED="1267976843667" ID="ID_810075375" MODIFIED="1267976907285" TEXT="OSGi service (and platform) know only this interface, &#xa;and have not direct link with interpreter"/>
</node>
<node CREATED="1267976777861" FOLDED="true" ID="ID_229840446" MODIFIED="1267978762436" TEXT="JythonBridge">
<node CREATED="1267976916707" ID="ID_1063872334" MODIFIED="1267976934038" TEXT="Implementation of IScriptBridge interface for Jython"/>
<node CREATED="1267976936330" ID="ID_1317908734" MODIFIED="1267976963605" TEXT="It directly knows the information related to the Jython interpreter"/>
<node CREATED="1267976964807" ID="ID_1323710382" MODIFIED="1267976978654" TEXT="It implements the real OSGi service Object"/>
</node>
<node CREATED="1267976781660" ID="ID_1388567690" MODIFIED="1267978763344" TEXT="Jython">
<node CREATED="1267976983485" ID="ID_1467531821" MODIFIED="1267976992889" TEXT="Jython interpreter version 2.5.1"/>
<node CREATED="1267976993335" ID="ID_1796778062" MODIFIED="1267977009125" TEXT="wrapped in OSGi bundle with bnd utility"/>
<node CREATED="1267977014215" ID="ID_273537366" MODIFIED="1267977034382" TEXT="Python interpreter written in java"/>
</node>
</node>
</node>
<node CREATED="1267975993713" ID="ID_1242879015" MODIFIED="1267978299263" POSITION="right" TEXT="Goals">
<icon BUILTIN="idea"/>
<node CREATED="1267975669578" FOLDED="true" ID="ID_393493185" MODIFIED="1267978381646" TEXT="OSGi from Jython">
<font BOLD="true" NAME="SansSerif" SIZE="12"/>
<icon BUILTIN="full-1"/>
<node CREATED="1267975682423" ID="ID_1370423103" MODIFIED="1267975685484" TEXT="call services"/>
<node CREATED="1267975685817" ID="ID_945107295" MODIFIED="1267975694601" TEXT="use OSGi service objects"/>
<node CREATED="1267975703959" FOLDED="true" ID="ID_1429072654" MODIFIED="1267978381168" TEXT="use OSGi specific components">
<node CREATED="1267978353360" ID="ID_1702627612" MODIFIED="1267978357880" TEXT="service tracker"/>
<node CREATED="1267978358317" ID="ID_475123565" MODIFIED="1267978361504" TEXT="dynamic services"/>
<node CREATED="1267978366612" ID="ID_1264111523" MODIFIED="1267978370767" TEXT="Bundle objects"/>
<node CREATED="1267978362038" ID="ID_1176178821" MODIFIED="1267978363730" TEXT="ecc. ecc."/>
</node>
</node>
<node CREATED="1267975736995" FOLDED="true" ID="ID_1264544599" MODIFIED="1267978342544" TEXT="Jython from OSGi">
<font BOLD="true" NAME="SansSerif" SIZE="12"/>
<icon BUILTIN="full-2"/>
<node COLOR="#338800" CREATED="1267975743467" FOLDED="true" ID="ID_1996079619" MODIFIED="1267978335045" TEXT="call Jython scripts">
<font BOLD="true" NAME="SansSerif" SIZE="12"/>
<icon BUILTIN="button_ok"/>
<node CREATED="1267978320604" ID="ID_175410720" MODIFIED="1267978330992" TEXT="execute_script entry point"/>
</node>
<node CREATED="1267975763897" FOLDED="true" ID="ID_577748105" MODIFIED="1267978337751" TEXT="use Jython objects">
<node CREATED="1267977833372" ID="ID_1968364639" LINK="http:/wiki.python.org/jython/JythonMonthly/Articles/October2006/3" MODIFIED="1267977853634" TEXT="article"/>
<node CREATED="1267977907071" ID="ID_382824665" MODIFIED="1267978174948" TEXT="probably, you can create OSGi interface in Java, &#xa;then create a Service implementation in Jython, &#xa;and a Factory service that create Java Object from&#xa;Jython object and register Java object into OSGi&#xa;platform&#xa;">
<icon BUILTIN="idea"/>
</node>
</node>
<node CREATED="1267975769060" ID="ID_1900308590" MODIFIED="1267975784428" TEXT="use specific Python library"/>
<node CREATED="1267975803836" ID="ID_708480844" MODIFIED="1267975817018" TEXT="manage an OSGi Jython based service"/>
</node>
</node>
</node>
</map>
