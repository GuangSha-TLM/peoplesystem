<!--
 * @Author: tianleiyu 
 * @Date: 2024-03-07 09:47:20
 * @LastEditTime: 2024-03-13 14:44:57
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /people/src/components/List.vue
 * 可以输入预定的版权声明、个性签名、空行等
-->

<template>
    <div :class="{ pc: !$isMobile, mobile: $isMobile }">
        <el-button type="primary" class="arrow-left" v-if="isList" icon="el-icon-arrow-left" @click="go">上一页
        </el-button>
        <!-- 1.**下载按钮 -->
        <el-button type="primary" @click="download" v-if="isList">下载<i
                class="el-icon-download el-icon--right"></i></el-button>

        <el-table :data="list" height="100%" border @selection-change="handleSelectionChange">
            <el-table-column type="selection" v-if="!isList">
            </el-table-column>
            <el-table-column prop="stuId" label="序号">
            </el-table-column>
            <el-table-column prop="stuName" label="姓名">
            </el-table-column>
            <el-table-column prop="status" label="状态">
                <!-- <template slot="header" slot-scope="scope">
                    <el-button type="primary" @click="toggleSelection()">修改</el-button>
                </template> -->
                <template slot-scope="scope">
                    {{ scope.row.status === 1 ? '未选择' : "已选择" }}
                </template>

            </el-table-column>

        </el-table>
    </div>

</template>

<script>

export default {
    data() {
        return {
            // multipleSelection: [],
            isList:false
        }
    },
    mounted() {
        // console.log(this.$route.path);
        if (this.$route.path != '/') {
            this.isList = true
            if (this.list.length == 0) {
                // 在这里执行重定向到home页面的逻辑  
                // 例如：使用this.$router.push({ name: 'home' }); 
                this.$router.push('/');
            }
        }

    },
    methods: {
        //单个操作
        // deleteRow(index, rows) {
        //     rows.splice(index, 1);
        // },
        //多选操作
        handleSelectionChange(val) {
            var IdList = []
            for (let index = 0; index < val.length; index++) {
                var id = val[index].stuId;
                IdList.push(id);
            }
            this.$emit('multipleSelection',IdList)
        },
        // toggleSelection() {
        //     resUpdateStatus(this.multipleSelection).then((res) => {
        //         console.log(res);
        //         if (res.data.code === '0x200') {
        //             this.$message({
        //                 showClose: true,
        //                 message: '修改成功!',
        //                 type: 'success'
        //             });
        //             this.$emit('getAllStu')
        //         } else {
        //             this.$message({
        //                 showClose: true,
        //                 message: res.data.message,
        //                 type: 'error'
        //             });
        //         }
        //     })
        // },
        go(){
            this.$router.go(-2)
        },
        //抽取之后的下载功能的方法
        //需要获取抽取到人的id

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
                })
        }
    },
    props: {
        lists: {
            type: Array,
            default: () => []
        },
        multipleSelection:{
            type: Array,
            default: () => []
        }
    },
    computed: {
        list() {
            // 检查路由 params 中是否有需要的数据  
            let list = this.$route.params.list;
            // 如果 params 中有数据，则返回它  
            if (list) {
                return list;
            }
            // 否则，返回从 props 中获取的数据  
            if (this.lists) {
                return this.lists;
            }
            return []
        }
    }
}
</script>

<style lang="scss" scoped>
::v-deep .el-button--primary {
    background-color: #abc1ee;
    border: 0;
}
::v-deep .el-table__cell {
    padding: 10px 0;
}
::v-deep .cell{
    padding-left: 0 ;
    text-align: center;
}

// ::v-deep .el-button{
//   background-color: #abc1ee;
// }
.pc{
    
}
.mobile{
    .arrow-left{
        background-color: #fff;
        color: #999;
    }
}
</style>