<!--
 * @Author: tianleiyu 
 * @Date: 2024-03-15 08:10:55
 * @LastEditTime: 2024-03-16 14:42:38
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
            <el-button type="primary" round v-for="item in buttonList" :key="item.id" @click="handleClick(item.id)">
                {{ item.channelName }}
            </el-button>
        </div>
    </div>
</template>

<script>
import { getAllChannel ,selectChannelByChaId ,chaWithStuByChaId} from '@/api/channel'
export default {
    name: 'home',
    data() {
        return {
            buttonList: []
        };
    },
    mounted() {
        this.getAllChannel()
    },
    methods: {
        getAllChannel() {
            getAllChannel().then(res => {
                this.buttonList = res.data.data
                // console.log(this.buttonList)
            })
        },
        handleClick(value) {
            console.log(value);
            // chaWithStuByChaId(value).then((res=>{
            //     console.log(res);
            //     if(res.status == 200){
                    //给home组件传递数据
                    // this.$bus.$emit('aisle',res.data)
                    this.$router.push({ name:'home',params:{id:value} })
                    // console.log(this.$router);
                // }
            // }))
        }
    },

}
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