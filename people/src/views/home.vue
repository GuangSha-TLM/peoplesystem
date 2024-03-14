<!--
 * @Author: tianleiyu 
 * @Date: 2024-03-07 13:31:22
 * @LastEditTime: 2024-03-08 17:48:19
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /people/src/views/home.vue
 * 可以输入预定的版权声明、个性签名、空行等
-->

<template>
  <div :class="{ pc: !$isMobile, mobile: $isMobile }">
    <!-- -->
    <div class="top">
      <el-button type="primary" @click="isUpload = true">上传<i class="el-icon-upload el-icon--right"></i></el-button>
      <el-button type="primary" @click="download">下载<i class="el-icon-download el-icon--right"></i></el-button>
      <router-link to="/extract"><el-button type="primary">摇人<i
            class="el-icon-user el-icon--right"></i></el-button></router-link>
      <el-button type="primary" @click="toggleSelection()">修改</el-button>
      <el-button type="primary" @click="deleteAll()">删除</el-button>
      

      <!-- <el-button type="text" @click="exceltype = true">点击打开 Dialog</el-button> -->
    </div>
    <List class="list" :lists="list" @getAllStu="getAllStu" @multipleSelection="getMultipleSelection" />


    <!-- 上传的表单 -->
    <el-dialog title="提示" :visible.sync="isUpload" width="70%" center>
      <el-upload class="upload-demo" action="#" :file-list="fileList" :auto-upload="false" :on-change="handleChange"
        :before-upload="beforeAvatarUpload" show-file-list :http-request="confirmUpload" :limit="1">
        <el-button size="small" type="primary">点击上传</el-button>
        <div slot="tip" class="el-upload__tip">只能上传xls/xlsx文件，且不超过10MB</div>
      </el-upload>
      <span slot="footer" class="dialog-footer">
        <el-button @click="isUpload = false">取 消</el-button>
        <el-button type="primary" @click="confirmUpload">确 定</el-button>
      </span>
    </el-dialog>


    <!--提示用户excel的格式  -->
    <el-dialog title="提示" :visible.sync="exceltype" center :show-close="false">
      <img src="@/assets/excelExample.png" alt="" width="100%">

      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="exceltype = false">我已确认</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import { resUpdateStatus ,deleteAll } from '@/api/user'
import List from '@/components/List.vue';
import { resGetStu, resUpload, resDownload } from '@/api/user';

export default {
  name: 'home',
  components: {
    List,
  },
  data() {
    return {
      list: [],
      isUpload: false,
      fileList: [],
      exceltype: false,
      multipleSelection:[]
    };
  },

  mounted() {
    this.getAllStu()
  },

  methods: {
    getMultipleSelection(multipleSelection){
      this.multipleSelection = multipleSelection
    },
    getAllStu() {
      resGetStu().then((res) => {
        if (res.data.code === '0x200') {
          this.list = res.data.data
        } else {
          this.$message({
            showClose: true,
            message: res.message,
            type: 'error'
          });
        }
      })
    },
    //element的上传
    confirmUpload() {
      const formData = new FormData();
      formData.append("multipartFile", this.fileList[0].raw)
      console.log(formData);
      resUpload(formData).then((res) => {
        if (res.data.code === '0x200') {
          console.log(res);
          this.$message({
            showClose: true,
            message: '上传成功!',
            type: 'success'
          });
          this.fileList = [];
          this.isUpload = false
        } else {
          this.$message({
            showClose: true,
            message: '数据不匹配,请检查excel后重新上传!',
            type: 'error'
          });
          this.exceltype = true
          this.fileList = [];
        }
      })
    },
    handleChange(file, fileList) { //文件数量改变
      this.fileList = fileList;
    },
    //判断类型
    beforeAvatarUpload(file) {
      const isXLS = file.type === 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet' || 'application/vnd.ms-excel';
      const isLt10M = file.size / 1024 / 1024 < 10;

      if (!isXLS) {
        this.$message.error('上传文件只能是 excel 格式!');
      }
      if (!isLt10M) {
        this.$message.error('上传文件大小不能超过 10MB!');
      }
      return isXLS && isLt10M;
    },
    download() {
      resDownload()
        .then(response => {
          if (response.status === 200) {
            const fileName = response.headers["content-disposition"].split(";")[1].split("=")[1]
            // console.log(decodeURIComponent(fileName));
            let link = document.createElement('a');
            link.href = window.URL.createObjectURL(response.data);
            link.download = decodeURIComponent(fileName);//设置下载文件名
            link.click();//模拟点击
            //释放资源并删除创建的a标签
            URL.revokeObjectURL(link.href);
            link.remove()
          }

        });

    },
    //修改接口
    toggleSelection() {
      resUpdateStatus(this.multipleSelection).then((res) => {
        console.log(res);
        if (res.data.code === '0x200') {
          this.$message({
            showClose: true,
            message: '修改成功!',
            type: 'success'
          });
          this.getAllStu()
        } else {
          this.$message({
            showClose: true,
            message: res.data.message,
            type: 'error'
          });
        }
      })
    },
    //删除
    deleteAll(){
      deleteAll().then((res) => {
        console.log(res);
        if (res.data.code === '0x200') {
          this.$message({
            showClose: true,
            message: '删除成功!',
            type: 'success'
          });
          this.getAllStu()
        } else {
          this.$message({
            showClose: true,
            message: res.data.message,
            type: 'error'
          });
        }
      })
  },
  
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
  width: 90%;
  margin: 0 auto;

  .top {
    width: 45%;
    display: flex;
    justify-content: space-around;
    margin: 10Px 0;

    ::v-deep .el-button {
      margin-left: 0;
    }
  }


}

.mobile {
  /*
      这里写移动端的样式
    */

  height: 100%;
  overflow-y: hidden;
  overflow-x: hidden;

  .top {
    height: 6%;
    display: flex;
    justify-content: space-around;
    margin: 1% 0;

    ::v-deep .el-button {
      margin-left: 0;
      height: 100%;
    }
  }

  ::v-deep .el-dialog {
    width: 100%;
  }

  .list {
    height: 92%;
  }

}
</style>