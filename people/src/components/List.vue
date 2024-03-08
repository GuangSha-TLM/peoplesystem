<!--
 * @Author: tianleiyu 
 * @Date: 2024-03-07 09:47:20
 * @LastEditTime: 2024-03-08 16:35:57
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /people/src/components/List.vue
 * 可以输入预定的版权声明、个性签名、空行等
-->

<template>
    <div :class="{ pc: !$isMobile, mobile: $isMobile }">
        <el-button type="primary" class="arrow-left" v-if="isList" icon="el-icon-arrow-left" @click="go">上一页 </el-button>
        <el-table :data="list" height="100%" border @selection-change="handleSelectionChange">
            <el-table-column type="selection">
            </el-table-column>
            <el-table-column prop="stuId" label="序号">
            </el-table-column>
            <el-table-column prop="stuName" label="姓名">
            </el-table-column>
            <el-table-column prop="status" label="状态">
                <template slot="header" slot-scope="scope">
                    <el-button type="primary" @click="toggleSelection()">修改</el-button>
                </template>
            </el-table-column>

        </el-table>
    </div>

</template>

<script>
import { resUpdateStatus } from '@/api/user'

export default {
    data() {
        return {
            multipleSelection: [],
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
            this.multipleSelection = IdList;
        },
        toggleSelection() {
            resUpdateStatus(this.multipleSelection).then((res) => {
                if (res.code === '0x200') {
                    this.$message({
                        showClose: true,
                        message: '修改成功!',
                        type: 'success'
                    });
                    this.$emit('getAllStu')
                } else {
                    this.$message({
                        showClose: true,
                        message: res.data.message,
                        type: 'error'
                    });
                }
            })
        },
        go(){
            this.$router.go(-2)
        }
    },
    props: {
        lists: {
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