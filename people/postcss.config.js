
module.exports = {
    plugins: {
        autoprefixer: {},
        'postcss-pxtorem': {
          rootValue: 75, // 根字体大小 设计稿750px --> 75 640px --> 64
          propList: ['*'], // 所有属性都转换
        }
      }
  }