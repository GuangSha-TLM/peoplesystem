<!--
 * @Author: tianleiyu 
 * @Date: 2024-03-04 16:49:15
 * @LastEditTime: 2024-03-04 17:22:28
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /peopleui/src/App.vue
 * 可以输入预定的版权声明、个性签名、空行等
-->
<template>
  <div id="app">
    <nav>
      <router-link to="/">Home</router-link> |
      <router-link to="/about">About</router-link>
    </nav>
    <router-view/>
  </div>
</template>

<style lang="scss">
*{
  padding: 0;
  margin: 0;
  box-sizing: border-box;
}
.icon{
  width: .5rem;
  height: .5rem;
}
a{
  color: black;
}
</style>
