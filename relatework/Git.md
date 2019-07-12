# git问题

最近出现项目中的git问题。

  `pathspec '1.6.2' did not match any file(s) known to g`
  
  
  
  这个时候是由于我在远程创建了一个分支，但是我在本地idea中的git并没有trace这个
  分支，需要我们去通步远端的trace，也可以同步自己想trace的分支
  
  git fetch zhangpan  *trace 同步zhangpan分支*
  
  git fecth *同步所有的trace（所有分支）*
  
  install:install -f pom.xml