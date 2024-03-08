<!--
 * @Author: tianleiyu 
 * @Date: 2024-03-04 16:49:15
 * @LastEditTime: 2024-03-08 16:42:43
 * @LastEditors: tianleiyu
 * @Description: login
 * @FilePath: /people/src/views/extract.vue
 * 可以输入预定的版权声明、个性签名、空行等
-->

<template>
    <div :class="{ pc: !$isMobile, mobile: $isMobile }">
        <div class="container">
            <div class="login-wrapper">
                <el-form :model="extract" :rules="rules" ref="extract" class="demo-ruleForm">
                    <div class="form-wrapper">
                        <div class="header">请选择要抽取的人数</div>
                        <el-form-item  prop="region">
                            <el-select v-model.number="extract.number" placeholder="请选择人数" class="input-item">
                                <el-option label="1人" value=1></el-option>
                                <el-option label="2人" value=2></el-option>
                                <el-option label="3人" value=3></el-option>
                                <el-option label="4人" value=4></el-option>
                                <el-option label="5人" value=5></el-option>
                                <el-option label="6人" value=6></el-option>
                                <el-option label="7人" value=7></el-option>
                                <el-option label="8人" value=8></el-option>
                                <el-option label="9人" value=9></el-option>
                                <el-option label="10人" value=10></el-option>
                            </el-select>
                        </el-form-item>
                        <el-form-item>
                            <el-button class="btn" type="primary" @click="submitForm('extract')">抽取</el-button>
                        </el-form-item>
                    </div>
                </el-form>
            </div>
        </div>
    </div>
</template>

<script>
import { resUserShake } from '@/api/user';
export default {
    name: 'HomeView',
    data() {
        return {
            extract: {
                number: 1,
            },
            rules: {
                number: [
                    { required: true, message: '人数不能为空' },
                    { type: 'number', message: '人数必须为数字值' }
                ],
            }
        }
    },
    methods: {
        submitForm(formName) {
            this.$refs[formName].validate((valid) => {
                if (valid) {
                    resUserShake(this.extract)
                    .then(res => {
                        if (res.data.code==='0x200') {
                            this.$message({
                                showClose: true,
                                message: '抽取成功!',
                                type: 'success'
                            });
                            this.$router.push({name: 'list',params:{list:res.data.data}})
                        } else {
                            this.$message({
                                showClose: true,
                                message: res.data.message,
                                type: 'error'
                            });
                        }
                    })
                    .catch(err => {
                        console.log(err);
                    })
                } else {
                    return false;
                }
            });
        },
    }
}
</script>

<style lang="scss" scoped>
.pc {
    height: 100%;

    /*
      这里写PC端的样式
    */
    .container {
        height: 100%;
        background-color: #f7f7f7;
        // background-image: linear-gradient(to right, #fbc2eb, #a6c1ee);
    }

    .login-wrapper {
        background-color: #fff;
        width: 358Px;
        height: 588Px;
        border-radius: 15Px;
        padding: 0 50Px;
        position: relative;
        left: 50%;
        top: 50%;
        transform: translate(-50%, -50%);
    }

    .header {
        font-size: 28Px;
        font-weight: bold;
        text-align: center;
        line-height: 200Px;
    }

    .input-item {
        display: block;
        width: 100%;
        margin-bottom: 20Px;
        border: 0;
        padding: 10Px;
        border-bottom: 1Px solid rgb(128, 125, 125);
        font-size: 15Px;
        outline: none;
    }

    .input-item:placeholder {
        text-transform: uppercase;
    }

    .btn {
        text-align: center;
        padding: 15Px;
        width: 100%;
        margin-top: 25Px;
        background-color: #abc1ee;
        // background-image: linear-gradient(to right, #a6c1ee, #fbc2eb);
        color: #fff;
    }

    .msg {
        text-align: center;
        line-height: 88Px;
    }

    a {
        text-decoration-line: none;
        color: #abc1ee;
    }

    ::v-deep .el-input__inner {
        border: 0;
        padding: 0;
        text-align: center;
    }


    ::v-deep .el-button--primary {
        border: 0;
    }


}

.mobile {
    /*
      这里写移动端的样式
    */

    height: 100%;

    .container {
        height: 100%;
        background-color: #f7f7f7;
        // background-image: linear-gradient(to right, #fbc2eb, #a6c1ee);
    }

    .login-wrapper {
        // background-image: linear-gradient(to right, #fbc2eb, #a6c1ee);

        background-color: #fff;
        width: 80%;
        height: 50%;
        border-radius: 15px;
        padding: 0 50px;
        position: relative;
        left: 50%;
        top: 50%;
        transform: translate(-50%, -50%);
    }

    .header {
        font-size: 38px;
        font-weight: bold;
        text-align: center;
        line-height: 150px;
    }

    .input-item {
        display: block;
        width: 100%;
        margin-bottom: 20px;
        border: 0;
        padding: 10px;
        border-bottom: 1px solid rgb(128, 125, 125);
        font-size: 25px;
        outline: none;
    }

    ::v-deep .el-input__inner {
        border: 0;
        padding: 0;
        text-align: center;
    }

    ::v-deep .el-form-item__content {
        line-height: 10px;
    }

    ::v-deep .el-button--primary {
        border: 0;
    }


    .input-item:placeholder {
        text-transform: uppercase;
    }

    .btn {
        text-align: center;
        padding: 10px;
        width: 100%;
        margin-top: 25px;
        background-color: #abc1ee;
        // background-image: linear-gradient(to right, #a6c1ee, #fbc2eb);
        color: #fff;
        font-size: 30px;
        height: 100px;
    }

    .msg {
        text-align: center;
        line-height: 88px;
    }

    a {
        text-decoration-line: none;
        color: #abc1ee;
        font-size: 30px;
    }
}
</style>