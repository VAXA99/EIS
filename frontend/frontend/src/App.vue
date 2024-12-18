<template>
  <div id="app">
    <h1>Управление поездами</h1>
    <TrainForm />
    <TrainList />
  </div>
</template>

<script>
import TrainList from '@/components/TrainList.vue';
import TrainForm from '@/components/TrainForm.vue';

export default {
  components: {
    TrainList,
    TrainForm,
  },
};
</script>
