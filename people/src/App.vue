<!--
 * @Author: tianleiyu 
 * @Date: 2024-03-04 16:49:15
 * @LastEditTime: 2024-03-05 13:47:05
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /people/src/App.vue
 * 可以输入预定的版权声明、个性签名、空行等
-->

<template>
  <div id="app">
    <!-- <nav> -->
      <!-- <router-link to="/login">Login</router-link> | -->
      <!-- <router-link to="/about">About</router-link> -->
    <!-- </nav> -->
    <router-view />
  </div>
</template>

<style lang="scss">
* {
  padding: 0;
  margin: 0;
  box-sizing: border-box;
}

.icon {
  width: .5rem;
  height: .5rem;
}

a {
  color: black;
}

html {
  height: 100%;
}

body {
  height: 100%;
}
#app {
  height: 100%;
}
</style>
