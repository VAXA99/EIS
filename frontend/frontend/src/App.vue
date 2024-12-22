<template>
  <div id="app">
    <h1>Управление поездами</h1>
    <TrainForm @refresh="refreshList" ref="form" />
    <TrainList @edit="editTrain" ref="list" />
  </div>
</template>

<script>
import TrainForm from "@/components/TrainForm.vue";
import TrainList from "@/components/TrainList.vue";

export default {
  components: {
    TrainForm,
    TrainList,
  },
  methods: {
    refreshList() {
      this.$refs.list.fetchTrains();
    },
    editTrain(train) {
      this.$refs.form.editTrain(train);
    },
  },
};
</script>
