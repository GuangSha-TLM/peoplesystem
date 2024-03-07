<!--
 * @Author: tianleiyu 
 * @Date: 2024-03-07 13:31:22
 * @LastEditTime: 2024-03-07 14:56:53
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /people/src/views/home.vue
 * 可以输入预定的版权声明、个性签名、空行等
-->
<template>
  <div>
    <!-- --> 
    <List />
  </div>
</template>

<script>
import List from '@/components/List.vue';

export default {
  name: 'home',

  data() {
    return {
      
    };
  },

  mounted() {
    
  },

  methods: {
    
  },
};
</script>
<style lang="scss" scoped>
.pc {
    height: 100%;

    /*
      这里写PC端的样式
    */
    


}

.mobile {
    /*
      这里写移动端的样式
    */

    height: 100%;

    
}
</style>