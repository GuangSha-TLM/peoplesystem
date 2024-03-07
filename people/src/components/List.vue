<!--
 * @Author: tianleiyu 
 * @Date: 2024-03-07 09:47:20
 * @LastEditTime: 2024-03-07 13:47:55
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /people/src/components/List.vue
 * 可以输入预定的版权声明、个性签名、空行等
-->

<template>
    <el-table :data="list" border style="width: 100%">
        <!-- <el-table-column type="selection" width="55">
        </el-table-column> -->
        <el-table-column prop="stuId" label="序号">
        </el-table-column>
        <el-table-column prop="stuName" label="姓名">
        </el-table-column>
        <el-table-column prop="status" label="状态">
        </el-table-column>
        <el-table-column fixed="right" label="操作">
            <template slot-scope="scope">
                <el-button @click.native.prevent="deleteRow(scope.$index, tableData)" type="text" size="small">
                    修改状态
                </el-button>
            </template>
        </el-table-column>
    </el-table>
</template>

<script>
export default {
    data() {
        return {
            // multipleSelection: []
        }
    },
    mounted() {
        if (this.list.length == 0) {
            // 在这里执行重定向到home页面的逻辑  
            // 例如：使用this.$router.push({ name: 'home' }); 
            this.$router.push('/');
        }
    },
    methods: {
        //单个操作
        deleteRow(index, rows) {
            rows.splice(index, 1);
        }
        //多选操作
        //     toggleSelection(rows) {
        //     if (rows) {
        //       rows.forEach(row => {
        //         this.$refs.multipleTable.toggleRowSelection(row);
        //       });
        //     } else {
        //       this.$refs.multipleTable.clearSelection();
        //     }
        //   },
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
            console.log(list);
            // 如果 params 中有数据，则返回它  
            if (list) {
                return list;
            }
            console.log(this.lists);
            // 否则，返回从 props 中获取的数据  
            if (this.lists) {
                return this.lists;

            }
            return []
        }
    }
}
</script>