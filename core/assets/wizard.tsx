<?xml version="1.0" encoding="UTF-8"?>
<tileset version="1.4" tiledversion="1.4.3" name="wizard" tilewidth="16" tileheight="32" tilecount="24" columns="4">
 <properties>
  <property name="died" type="int" value="22"/>
  <property name="go_down" type="int" value="0"/>
  <property name="go_left" type="int" value="12"/>
  <property name="go_right" type="int" value="4"/>
  <property name="go_up" type="int" value="8"/>
  <property name="idle" type="int" value="18"/>
 </properties>
 <image source="wizard.png" trans="000000" width="73" height="200"/>
 <tile id="0">
  <properties>
   <property name="type" value="Enemy"/>
  </properties>
  <objectgroup draworder="index" id="2">
   <object id="1" name="collision" x="1.41022" y="24.9501" width="12.692" height="5.85785"/>
  </objectgroup>
  <animation>
   <frame tileid="0" duration="230"/>
   <frame tileid="1" duration="230"/>
   <frame tileid="2" duration="230"/>
   <frame tileid="3" duration="230"/>
  </animation>
 </tile>
 <tile id="4">
  <objectgroup draworder="index" id="2">
   <object id="1" name="collision" x="0.433915" y="24.4077" width="14.2107" height="5.96633"/>
  </objectgroup>
  <animation>
   <frame tileid="4" duration="230"/>
   <frame tileid="5" duration="230"/>
   <frame tileid="6" duration="230"/>
   <frame tileid="7" duration="230"/>
  </animation>
 </tile>
 <tile id="8">
  <objectgroup draworder="index" id="2">
   <object id="1" name="collision" x="1.73566" y="25.384" width="12.909" height="5.20698"/>
  </objectgroup>
  <animation>
   <frame tileid="8" duration="230"/>
   <frame tileid="9" duration="230"/>
   <frame tileid="10" duration="230"/>
   <frame tileid="11" duration="230"/>
  </animation>
 </tile>
 <tile id="12">
  <objectgroup draworder="index" id="2">
   <object id="1" name="collision" x="1.30174" y="24.8416" width="13.5598" height="5.31546"/>
  </objectgroup>
  <animation>
   <frame tileid="12" duration="230"/>
   <frame tileid="13" duration="230"/>
   <frame tileid="14" duration="230"/>
   <frame tileid="15" duration="230"/>
  </animation>
 </tile>
 <tile id="18">
  <objectgroup draworder="index" id="2">
   <object id="1" name="collision" x="1.19327" y="24.7331" width="13.4514" height="5.31546"/>
  </objectgroup>
  <animation>
   <frame tileid="18" duration="480"/>
   <frame tileid="20" duration="480"/>
  </animation>
 </tile>
 <tile id="22">
  <animation>
   <frame tileid="22" duration="230"/>
   <frame tileid="23" duration="80"/>
   <frame tileid="22" duration="230"/>
   <frame tileid="23" duration="80"/>
   <frame tileid="22" duration="230"/>
   <frame tileid="23" duration="80"/>
  </animation>
 </tile>
</tileset>
