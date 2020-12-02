<?xml version="1.0" encoding="UTF-8"?>
<tileset version="1.4" tiledversion="1.4.2" name="char1_16_32" tilewidth="16" tileheight="32" tilecount="52" columns="4">
 <properties>
  <property name="died" type="int" value="32"/>
  <property name="go_down" type="int" value="0"/>
  <property name="go_left" type="int" value="12"/>
  <property name="go_right" type="int" value="4"/>
  <property name="go_up" type="int" value="8"/>
  <property name="idle" type="int" value="24"/>
 </properties>
 <image source="char1.png" width="74" height="418"/>
 <tile id="0">
  <properties>
   <property name="type" value="Main"/>
  </properties>
  <objectgroup draworder="index" id="3">
   <object id="2" name="collision" x="2" y="23" width="12" height="5"/>
  </objectgroup>
  <animation>
   <frame tileid="0" duration="180"/>
   <frame tileid="1" duration="180"/>
   <frame tileid="2" duration="180"/>
   <frame tileid="3" duration="180"/>
  </animation>
 </tile>
 <tile id="4">
  <objectgroup draworder="index" id="2">
   <object id="3" name="collision" x="2" y="23" width="12" height="5"/>
  </objectgroup>
  <animation>
   <frame tileid="4" duration="180"/>
   <frame tileid="5" duration="180"/>
   <frame tileid="6" duration="180"/>
   <frame tileid="7" duration="180"/>
  </animation>
 </tile>
 <tile id="5">
  <objectgroup draworder="index" id="2">
   <object id="1" name="collision" x="1.56421" y="25.0091" width="16.1443" height="5.2545"/>
  </objectgroup>
 </tile>
 <tile id="6">
  <objectgroup draworder="index" id="2">
   <object id="1" name="collision" x="1.56421" y="25.0091" width="16.1443" height="5.2545"/>
  </objectgroup>
 </tile>
 <tile id="7">
  <objectgroup draworder="index" id="2">
   <object id="1" name="collision" x="1.56421" y="25.0091" width="16.1443" height="5.2545"/>
  </objectgroup>
 </tile>
 <tile id="8">
  <objectgroup draworder="index" id="2">
   <object id="2" name="collision" x="2" y="23" width="12" height="5"/>
  </objectgroup>
  <animation>
   <frame tileid="8" duration="180"/>
   <frame tileid="9" duration="180"/>
   <frame tileid="10" duration="180"/>
   <frame tileid="11" duration="180"/>
  </animation>
 </tile>
 <tile id="9">
  <objectgroup draworder="index" id="2">
   <object id="1" name="collision" x="1.56421" y="25.0091" width="16.1443" height="5.2545"/>
  </objectgroup>
 </tile>
 <tile id="10">
  <objectgroup draworder="index" id="2">
   <object id="1" name="collision" x="1.56421" y="25.0091" width="16.1443" height="5.2545"/>
  </objectgroup>
 </tile>
 <tile id="11">
  <objectgroup draworder="index" id="2">
   <object id="1" name="collision" x="1.56421" y="25.0091" width="16.1443" height="5.2545"/>
  </objectgroup>
 </tile>
 <tile id="12">
  <objectgroup draworder="index" id="2">
   <object id="2" name="collision" x="2" y="23" width="12" height="5"/>
  </objectgroup>
  <animation>
   <frame tileid="12" duration="180"/>
   <frame tileid="13" duration="180"/>
   <frame tileid="14" duration="180"/>
   <frame tileid="15" duration="180"/>
  </animation>
 </tile>
 <tile id="13">
  <objectgroup draworder="index" id="2">
   <object id="1" name="collision" x="1.56421" y="25.0091" width="16.1443" height="5.2545"/>
  </objectgroup>
 </tile>
 <tile id="14">
  <objectgroup draworder="index" id="2">
   <object id="1" name="collision" x="1.56421" y="25.0091" width="16.1443" height="5.2545"/>
  </objectgroup>
 </tile>
 <tile id="15">
  <objectgroup draworder="index" id="2">
   <object id="1" name="collision" x="1.56421" y="25.0091" width="16.1443" height="5.2545"/>
  </objectgroup>
 </tile>
 <tile id="24">
  <objectgroup draworder="index" id="2">
   <object id="2" name="collision" x="2" y="23" width="12" height="5"/>
  </objectgroup>
  <animation>
   <frame tileid="24" duration="410"/>
   <frame tileid="25" duration="410"/>
   <frame tileid="26" duration="410"/>
   <frame tileid="27" duration="410"/>
  </animation>
 </tile>
 <tile id="32">
  <animation>
   <frame tileid="32" duration="150"/>
   <frame tileid="39" duration="80"/>
   <frame tileid="32" duration="150"/>
   <frame tileid="39" duration="80"/>
   <frame tileid="32" duration="150"/>
   <frame tileid="39" duration="80"/>
  </animation>
 </tile>
</tileset>
