XX集团准备成立新的交付团队--天宫，以完成某向软件开发任务
1.可以向天宫团队assign 成员（member）和交付任务（story）。
2.成员分为BA，DEV和QA。assign的成员和角色没有数量限制。
3.交付团队提供getMembers方法，能够根据getMembers的入参lambda返回适当的成员list
4.BA的工作是为交付团队产生1～3个新的story，并且给所有空闲的DEV assign一张卡（不需要考虑分配机制和策略）；DEV的工作是实现被assign的story。QA的工作是测试（移除）2个完成的卡（无特定要求怎么选择2个卡）。
5.DEV在已分配story的情况下再次分配新的story时，会产生带宽不足异常。
