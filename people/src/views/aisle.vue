<!--
 * @Author: tianleiyu 
 * @Date: 2024-03-15 08:10:55
 * @LastEditTime: 2024-03-15 09:21:43
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /people/src/views/aisle.vue
 * 可以输入预定的版权声明、个性签名、空行等
-->
<template>
    <div :class="{ pc: !$isMobile, mobile: $isMobile }">
        <!-- -->
        <div class="title">
            <h1>请选择通道</h1>
        </div>
        <div class="butList">
            <el-button type="primary" round v-for="(item, index) in buttonList" :key="index"
                @click="handleClick(item.value)">
                {{ item.label }}
            </el-button>
        </div>
    </div>
</template>

<script>

export default {
    name: 'home',
    data() {
        return {
            buttonList: [
                { value: 'stu', label: '学生' },
                { value: 'teacher', label: '教师' }
            ]
        };
    },
    methods: {
        handleClick(value) {
            console.log(`点击了按钮: ${value}`);
            // 在这里根据value来处理点击事件，比如发送请求  
            // 例如，你可以根据value来构建URL并发送请求  
            // this.sendRequest(value);  
        }
    },
};
</script>

<style lang="scss" scoped>
::v-deep .el-button--primary {
    background-color: #abc1ee;
    border: 0;
}

.pc {
    height: 100%;
    
    /*
        这里写PC端的样式
      */
    // display: flex;
    // flex-direction: column;
    // align-items: center;
    // justify-content: space-evenly;
    padding: 20Px;
    // background-color: #f5f5f5;
    width: 100%;

    .title {
        width: 90%;
        display: flex;
        justify-content: center;
        margin: 20% auto;
    }

    .butList {
        width: 90%;
        display: flex;
        flex-direction: column;
        justify-content: center;
        margin: 0 auto;
        .el-button {
            width: 100%;
            margin-left: 0;
            margin-bottom: 20Px;
            line-height: 2;
        }
    }
}

.mobile {
    /*
        这里写移动端的样式
      */

    height: 100%;
    /*
        这里写PC端的样式
      */
    // display: flex;
    // flex-direction: column;
    // align-items: center;
    // justify-content: space-evenly;
    padding: 20px;
    // background-color: #f5f5f5;
    width: 100%;

    .title {
        width: 90%;
        display: flex;
        justify-content: center;
        margin: 20% auto;
    }

    .butList {
        width: 90%;
        display: flex;
        flex-direction: column;
        justify-content: center;
        margin: 0 auto;
        .el-button {
            width: 100%;
            margin-left: 0;
            margin-bottom: 20px;
            line-height: 2;
        }
    }

}
</style>