<?xml version="1.0" encoding="UTF-8"?>
<tileset version="1.4" tiledversion="1.4.3" name="bomb2" tilewidth="16" tileheight="16" tilecount="100" columns="10">
 <properties>
  <property name="bomb" type="int" value="0"/>
  <property name="bottom_explosion" type="int" value="37"/>
  <property name="center_explosion" type="int" value="27"/>
  <property name="horizontal_explosion" type="int" value="38"/>
  <property name="left_explosion" type="int" value="26"/>
  <property name="right_explosion" type="int" value="28"/>
  <property name="top_explosion" type="int" value="17"/>
  <property name="vertical_explosion" type="int" value="18"/>
 </properties>
 <image source="bomb2.png" trans="1f8b00" width="160" height="160"/>
 <tile id="0">
  <properties>
   <property name="type" value="Bomb"/>
  </properties>
  <objectgroup draworder="index" id="3">
   <object id="2" name="collision" x="4.3125" y="11.5" width="7.9375" height="4.5625"/>
  </objectgroup>
  <animation>
   <frame tileid="0" duration="200"/>
   <frame tileid="1" duration="200"/>
   <frame tileid="2" duration="200"/>
  </animation>
 </tile>
 <tile id="11">
  <objectgroup draworder="index" id="2">
   <object id="1" name="effect_range" x="0" y="0" width="16" height="16">
    <properties>
     <property name="effect_type" value="EXPLOSION_NON_DUP"/>
    </properties>
   </object>
  </objectgroup>
 </tile>
 <tile id="14">
  <objectgroup draworder="index" id="2">
   <object id="1" name="effect_range" x="0" y="0" width="16" height="16">
    <properties>
     <property name="effect_type" value="EXPLOSION_NON_DUP"/>
    </properties>
   </object>
  </objectgroup>
 </tile>
 <tile id="17">
  <properties>
   <property name="type" value="Explosion"/>
  </properties>
  <objectgroup draworder="index" id="2">
   <object id="1" name="effect_range" x="0" y="0" width="16" height="16">
    <properties>
     <property name="effect_type" value="EXPLOSION_NON_DUP"/>
    </properties>
   </object>
  </objectgroup>
  <animation>
   <frame tileid="17" duration="50"/>
   <frame tileid="41" duration="50"/>
   <frame tileid="11" duration="50"/>
   <frame tileid="14" duration="50"/>
   <frame tileid="14" duration="50"/>
   <frame tileid="11" duration="50"/>
   <frame tileid="41" duration="50"/>
   <frame tileid="17" duration="50"/>
  </animation>
 </tile>
 <tile id="18">
  <properties>
   <property name="type" value="Explosion"/>
  </properties>
  <objectgroup draworder="index" id="2">
   <object id="1" name="effect_range" x="0" y="0" width="16" height="16">
    <properties>
     <property name="effect_type" value="EXPLOSION_NON_DUP"/>
    </properties>
   </object>
  </objectgroup>
  <animation>
   <frame tileid="18" duration="50"/>
   <frame tileid="60" duration="50"/>
   <frame tileid="30" duration="50"/>
   <frame tileid="33" duration="50"/>
   <frame tileid="33" duration="50"/>
   <frame tileid="30" duration="50"/>
   <frame tileid="60" duration="50"/>
   <frame tileid="18" duration="50"/>
  </animation>
 </tile>
 <tile id="20">
  <objectgroup draworder="index" id="2">
   <object id="1" name="effect_range" x="0" y="0" width="16" height="16">
    <properties>
     <property name="effect_type" value="EXPLOSION_NON_DUP"/>
    </properties>
   </object>
  </objectgroup>
 </tile>
 <tile id="21">
  <objectgroup draworder="index" id="2">
   <object id="1" name="effect_range" x="0" y="0" width="16" height="16">
    <properties>
     <property name="effect_type" value="EXPLOSION_NON_DUP"/>
    </properties>
   </object>
  </objectgroup>
 </tile>
 <tile id="22">
  <objectgroup draworder="index" id="2">
   <object id="1" name="effect_range" x="0" y="0" width="16" height="16">
    <properties>
     <property name="effect_type" value="EXPLOSION_NON_DUP"/>
    </properties>
   </object>
  </objectgroup>
 </tile>
 <tile id="23">
  <objectgroup draworder="index" id="2">
   <object id="1" name="effect_range" x="0" y="0" width="16" height="16">
    <properties>
     <property name="effect_type" value="EXPLOSION_NON_DUP"/>
    </properties>
   </object>
  </objectgroup>
 </tile>
 <tile id="24">
  <objectgroup draworder="index" id="2">
   <object id="1" name="effect_range" x="0" y="0" width="16" height="16">
    <properties>
     <property name="effect_type" value="EXPLOSION_NON_DUP"/>
    </properties>
   </object>
  </objectgroup>
 </tile>
 <tile id="25">
  <objectgroup draworder="index" id="2">
   <object id="1" name="effect_range" x="0" y="0" width="16" height="16">
    <properties>
     <property name="effect_type" value="EXPLOSION_NON_DUP"/>
    </properties>
   </object>
  </objectgroup>
 </tile>
 <tile id="26">
  <properties>
   <property name="type" value="Explosion"/>
  </properties>
  <objectgroup draworder="index" id="2">
   <object id="1" name="effect_range" x="0" y="0" width="16" height="16">
    <properties>
     <property name="effect_type" value="EXPLOSION_NON_DUP"/>
    </properties>
   </object>
  </objectgroup>
  <animation>
   <frame tileid="26" duration="50"/>
   <frame tileid="50" duration="50"/>
   <frame tileid="20" duration="50"/>
   <frame tileid="23" duration="50"/>
   <frame tileid="23" duration="50"/>
   <frame tileid="20" duration="50"/>
   <frame tileid="50" duration="50"/>
   <frame tileid="26" duration="50"/>
  </animation>
 </tile>
 <tile id="27">
  <properties>
   <property name="type" value="Explosion"/>
  </properties>
  <objectgroup draworder="index" id="2">
   <object id="1" name="effect_range" x="0" y="-0.125" width="16" height="16">
    <properties>
     <property name="effect_type" value="EXPLOSION_NON_DUP"/>
    </properties>
   </object>
  </objectgroup>
  <animation>
   <frame tileid="27" duration="50"/>
   <frame tileid="51" duration="50"/>
   <frame tileid="21" duration="50"/>
   <frame tileid="24" duration="50"/>
   <frame tileid="24" duration="50"/>
   <frame tileid="21" duration="50"/>
   <frame tileid="51" duration="50"/>
   <frame tileid="27" duration="50"/>
  </animation>
 </tile>
 <tile id="28">
  <properties>
   <property name="type" value="Explosion"/>
  </properties>
  <objectgroup draworder="index" id="2">
   <object id="1" name="effect_range" x="0" y="0" width="16" height="16">
    <properties>
     <property name="effect_type" value="EXPLOSION_NON_DUP"/>
    </properties>
   </object>
  </objectgroup>
  <animation>
   <frame tileid="28" duration="50"/>
   <frame tileid="52" duration="50"/>
   <frame tileid="22" duration="50"/>
   <frame tileid="25" duration="50"/>
   <frame tileid="25" duration="50"/>
   <frame tileid="22" duration="50"/>
   <frame tileid="52" duration="50"/>
   <frame tileid="28" duration="50"/>
  </animation>
 </tile>
 <tile id="30">
  <objectgroup draworder="index" id="2">
   <object id="1" name="effect_range" x="0" y="0" width="16" height="16">
    <properties>
     <property name="effect_type" value="EXPLOSION_NON_DUP"/>
    </properties>
   </object>
  </objectgroup>
 </tile>
 <tile id="31">
  <objectgroup draworder="index" id="2">
   <object id="1" name="effect_range" x="0" y="0" width="16" height="16">
    <properties>
     <property name="effect_type" value="EXPLOSION_NON_DUP"/>
    </properties>
   </object>
  </objectgroup>
 </tile>
 <tile id="32">
  <objectgroup draworder="index" id="2">
   <object id="1" name="effect_range" x="0" y="0" width="16" height="16">
    <properties>
     <property name="effect_type" value="EXPLOSION_NON_DUP"/>
    </properties>
   </object>
  </objectgroup>
 </tile>
 <tile id="33">
  <objectgroup draworder="index" id="2">
   <object id="1" name="effect_range" x="0" y="0" width="16" height="16">
    <properties>
     <property name="effect_type" value="EXPLOSION_NON_DUP"/>
    </properties>
   </object>
  </objectgroup>
 </tile>
 <tile id="34">
  <objectgroup draworder="index" id="2">
   <object id="1" name="effect_range" x="0" y="0" width="16" height="16">
    <properties>
     <property name="effect_type" value="EXPLOSION_NON_DUP"/>
    </properties>
   </object>
  </objectgroup>
 </tile>
 <tile id="35">
  <objectgroup draworder="index" id="2">
   <object id="1" name="effect_range" x="0" y="0" width="16" height="16">
    <properties>
     <property name="effect_type" value="EXPLOSION_NON_DUP"/>
    </properties>
   </object>
  </objectgroup>
 </tile>
 <tile id="37">
  <properties>
   <property name="type" value="Explosion"/>
  </properties>
  <objectgroup draworder="index" id="2">
   <object id="1" name="effect_range" x="0" y="0" width="16" height="16">
    <properties>
     <property name="effect_type" value="EXPLOSION_NON_DUP"/>
    </properties>
   </object>
  </objectgroup>
  <animation>
   <frame tileid="37" duration="50"/>
   <frame tileid="61" duration="50"/>
   <frame tileid="31" duration="50"/>
   <frame tileid="34" duration="50"/>
   <frame tileid="34" duration="50"/>
   <frame tileid="31" duration="50"/>
   <frame tileid="61" duration="50"/>
   <frame tileid="37" duration="50"/>
  </animation>
 </tile>
 <tile id="38">
  <properties>
   <property name="type" value="Explosion"/>
  </properties>
  <objectgroup draworder="index" id="3">
   <object id="2" name="effect_range" x="0" y="0" width="16" height="16">
    <properties>
     <property name="effect_type" value="EXPLOSION_NON_DUP"/>
    </properties>
   </object>
  </objectgroup>
  <animation>
   <frame tileid="38" duration="50"/>
   <frame tileid="62" duration="50"/>
   <frame tileid="32" duration="50"/>
   <frame tileid="35" duration="50"/>
   <frame tileid="35" duration="50"/>
   <frame tileid="32" duration="50"/>
   <frame tileid="62" duration="50"/>
   <frame tileid="38" duration="50"/>
  </animation>
 </tile>
 <tile id="41">
  <objectgroup draworder="index" id="2">
   <object id="1" name="effect_range" x="0" y="0" width="16" height="16">
    <properties>
     <property name="effect_type" value="EXPLOSION_NON_DUP"/>
    </properties>
   </object>
  </objectgroup>
 </tile>
 <tile id="50">
  <objectgroup draworder="index" id="2">
   <object id="1" name="effect_range" x="0" y="0" width="16" height="16">
    <properties>
     <property name="effect_type" value="EXPLOSION_NON_DUP"/>
    </properties>
   </object>
  </objectgroup>
 </tile>
 <tile id="51">
  <objectgroup draworder="index" id="2">
   <object id="1" name="effect_range" x="0" y="0" width="16" height="16">
    <properties>
     <property name="effect_type" value="EXPLOSION_NON_DUP"/>
    </properties>
   </object>
  </objectgroup>
 </tile>
 <tile id="52">
  <objectgroup draworder="index" id="2">
   <object id="1" name="effect_range" x="0" y="0" width="16" height="16">
    <properties>
     <property name="effect_type" value="EXPLOSION_NON_DUP"/>
    </properties>
   </object>
  </objectgroup>
 </tile>
 <tile id="53">
  <animation>
   <frame tileid="53" duration="200"/>
   <frame tileid="54" duration="200"/>
   <frame tileid="55" duration="200"/>
   <frame tileid="56" duration="200"/>
   <frame tileid="57" duration="200"/>
   <frame tileid="58" duration="200"/>
   <frame tileid="59" duration="200"/>
  </animation>
 </tile>
 <tile id="60">
  <objectgroup draworder="index" id="2">
   <object id="1" name="effect_range" x="0" y="0" width="16" height="16">
    <properties>
     <property name="effect_type" value="EXPLOSION_NON_DUP"/>
    </properties>
   </object>
  </objectgroup>
 </tile>
 <tile id="61">
  <objectgroup draworder="index" id="2">
   <object id="1" name="effect_range" x="0" y="0" width="16" height="16">
    <properties>
     <property name="effect_type" value="EXPLOSION_NON_DUP"/>
    </properties>
   </object>
  </objectgroup>
 </tile>
 <tile id="62">
  <objectgroup draworder="index" id="2">
   <object id="1" name="effect_range" x="0" y="0" width="16" height="16">
    <properties>
     <property name="effect_type" value="EXPLOSION_NON_DUP"/>
    </properties>
   </object>
  </objectgroup>
 </tile>
 <tile id="63">
  <animation>
   <frame tileid="63" duration="100"/>
   <frame tileid="64" duration="100"/>
   <frame tileid="65" duration="100"/>
   <frame tileid="66" duration="100"/>
   <frame tileid="67" duration="100"/>
   <frame tileid="68" duration="100"/>
   <frame tileid="69" duration="100"/>
  </animation>
 </tile>
 <tile id="73">
  <animation>
   <frame tileid="79" duration="100"/>
   <frame tileid="73" duration="100"/>
   <frame tileid="74" duration="100"/>
   <frame tileid="75" duration="100"/>
   <frame tileid="76" duration="100"/>
   <frame tileid="77" duration="100"/>
   <frame tileid="78" duration="100"/>
   <frame tileid="79" duration="100"/>
  </animation>
 </tile>
 <tile id="80">
  <animation>
   <frame tileid="80" duration="200"/>
   <frame tileid="81" duration="200"/>
   <frame tileid="82" duration="200"/>
   <frame tileid="83" duration="200"/>
  </animation>
 </tile>
</tileset>
